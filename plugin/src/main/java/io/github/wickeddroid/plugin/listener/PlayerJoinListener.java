package io.github.wickeddroid.plugin.listener;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import io.github.wickeddroid.api.ranks.Rank;
import io.github.wickeddroid.plugin.user.UserRegistry;
import io.github.wickeddroid.plugin.util.JedisUtil;
import io.github.wickeddroid.plugin.util.PluginUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import redis.clients.jedis.JedisPool;
import team.unnamed.inject.Inject;

public class PlayerJoinListener implements Listener {

  @Inject
  private JedisPool jedisPool;

  @Inject
  private MongoDatabase mongoDatabase;

  @Inject
  private Plugin plugin;

  @Inject
  private UserRegistry userRegistry;

  @EventHandler
  public void onPlayerLogin(final PlayerJoinEvent event) {
    final var player = event.getPlayer();
    final var uuid = player.getUniqueId();
    final var code = PluginUtil.generateVerificationCode();
    final var collection = this.mongoDatabase.getCollection("users");

    if (this.userRegistry.getUser(uuid) != null) {
      return;
    }

    final var user = collection.find(Filters.eq("uuid", uuid.toString())).first() ;

    if (user != null) {
      final var rolDiscord = user.get("rolId", String.class);


      for (final var rank : Rank.values()) {
        if (rolDiscord.equals(rank.getId())) {
          final var attachment = player.addAttachment(plugin);

          for (final var permission : rank.getPermissions()) {
            attachment.setPermission(permission, true);
          }

          this.userRegistry.createUser(uuid, rank);
        }
      }

      return;
    }

    try (final var jedis = this.jedisPool.getResource()) {
      player.kick(Component.text("No te encuentras verificado en el discord. Usa el codigo: " + code));
      jedis.publish(JedisUtil.DISCORD_CHANNEL, String.format("%s:%s", player.getUniqueId(), code));
    }
  }
}
