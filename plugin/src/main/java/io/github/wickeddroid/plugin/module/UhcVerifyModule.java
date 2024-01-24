package io.github.wickeddroid.plugin.module;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import io.github.wickeddroid.plugin.mongo.MongoClientProvider;
import io.github.wickeddroid.plugin.mongo.MongoDatabaseProvider;
import io.github.wickeddroid.plugin.redis.JedisPoolProvider;
import org.bukkit.plugin.Plugin;
import redis.clients.jedis.JedisPool;
import team.unnamed.inject.AbstractModule;

public class UhcVerifyModule extends AbstractModule {

  private final Plugin plugin;

  public UhcVerifyModule(final Plugin plugin) {
    this.plugin = plugin;
  }

  @Override
  protected void configure() {
    bind(Plugin.class).toInstance(plugin);
    bind(JedisPool.class)
            .toProvider(new JedisPoolProvider())
            .singleton();

    bind(MongoClient.class)
            .toProvider(new MongoClientProvider())
            .singleton();

    bind(MongoDatabase.class)
            .toProvider(new MongoDatabaseProvider())
            .singleton();

    install(new LoaderModule());
  }
}
