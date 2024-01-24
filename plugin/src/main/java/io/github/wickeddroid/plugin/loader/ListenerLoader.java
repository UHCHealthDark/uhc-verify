package io.github.wickeddroid.plugin.loader;

import io.github.wickeddroid.api.loader.Loader;
import io.github.wickeddroid.plugin.listener.AsyncChatListener;
import io.github.wickeddroid.plugin.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import team.unnamed.inject.Inject;

public class ListenerLoader implements Loader {
  @Inject
  private Plugin plugin;

  @Inject
  private PlayerJoinListener playerJoinListener;

  @Inject
  private AsyncChatListener asyncChatListener;

  @Override
  public void load() {
    registerListeners(
            playerJoinListener,
            asyncChatListener
    );
  }

  private void registerListeners(final Listener... listeners) {
    for (final var listener : listeners) {
      Bukkit.getPluginManager().registerEvents(listener, plugin);
    }
  }
}
