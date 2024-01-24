package io.github.wickeddroid.plugin.user;

import io.github.wickeddroid.api.ranks.Rank;
import team.unnamed.inject.Singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class UserRegistry {

  private final Map<UUID, User> user = new HashMap<>();

  public void createUser(
          final UUID uuid,
          final Rank rank
  ) {
    this.user.put(uuid, new User(uuid, rank));
  }

  public void removeUser(final UUID uuid) {
    this.user.remove(uuid);
  }

  public User getUser(final UUID uuid) {
    return this.user.get(uuid);
  }
}
