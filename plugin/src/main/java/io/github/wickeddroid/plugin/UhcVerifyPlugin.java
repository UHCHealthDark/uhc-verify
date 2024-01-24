package io.github.wickeddroid.plugin;

import io.github.wickeddroid.api.loader.Loader;
import io.github.wickeddroid.plugin.loader.DefaultLoader;
import io.github.wickeddroid.plugin.module.LoaderModule;
import io.github.wickeddroid.plugin.module.UhcVerifyModule;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Inject;
import team.unnamed.inject.Injector;
import team.unnamed.inject.Named;

public class UhcVerifyPlugin extends JavaPlugin {

  @Inject
  @Named("main-loader")
  private Loader loader;

  @Override
  public void onEnable() {
    Injector.create(new UhcVerifyModule(this))
            .injectMembers(this);

    this.loader.load();
  }

  @Override
  public void onDisable() {
    this.loader.unload();
  }
}
