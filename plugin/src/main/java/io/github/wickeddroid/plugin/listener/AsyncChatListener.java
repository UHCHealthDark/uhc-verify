package io.github.wickeddroid.plugin.listener;

import io.github.wickeddroid.plugin.user.UserRegistry;
import io.github.wickeddroid.plugin.util.PluginUtil;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import team.unnamed.inject.Inject;

public class AsyncChatListener implements Listener {
  @Inject
  private UserRegistry userRegistry;

  @EventHandler(ignoreCancelled = true)
  public void onAsyncChat(final AsyncChatEvent event) {
    final var player = event.getPlayer();
    final var user = this.userRegistry.getUser(player.getUniqueId());
    final var rank = user.getRank();

    event.setCancelled(true);

    Bukkit.broadcast(PluginUtil.MINI_MESSAGE.deserialize(
            String.format("<color:%s><hover:show_text:%s>%s</hover></color> <gray>%s: ",
                    rank.getColor(),
                    rank.getDescription(),
                    rank.getPrefix(),
                    player.getName())
    ).append(event.message().color(TextColor.color(255, 255, 255))));
  }
}
