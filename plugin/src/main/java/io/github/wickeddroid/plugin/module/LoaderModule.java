package io.github.wickeddroid.plugin.module;

import io.github.wickeddroid.api.loader.Loader;
import io.github.wickeddroid.plugin.loader.DefaultLoader;
import io.github.wickeddroid.plugin.loader.ListenerLoader;
import team.unnamed.inject.AbstractModule;

public class LoaderModule extends AbstractModule {

  @Override
  protected void configure() {
    bindLoader("main-loader", DefaultLoader.class);
    bindLoader("redis-loader", RedisLoader.class);
    bindLoader("listener-loader", ListenerLoader.class);
  }

  private void bindLoader(
          final String name,
          final Class<? extends Loader> clazz
  ) {
    bind(Loader.class).named(name).to(clazz);
  }
}
