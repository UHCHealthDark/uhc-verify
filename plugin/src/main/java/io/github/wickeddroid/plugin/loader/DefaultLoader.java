package io.github.wickeddroid.plugin.loader;

import io.github.wickeddroid.api.loader.Loader;
import team.unnamed.inject.Inject;
import team.unnamed.inject.Named;

public class DefaultLoader implements Loader {
  @Inject
  @Named("listener-loader")
  private Loader listenerLoader;

  @Override
  public void load() {
    this.listenerLoader.load();
  }
}
