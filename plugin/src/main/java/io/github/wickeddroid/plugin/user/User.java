package io.github.wickeddroid.plugin.user;

import io.github.wickeddroid.api.ranks.Rank;

import java.util.UUID;

public class User {

  private final UUID uuid;
  private final Rank rank;

  public User(
          final UUID uuid,
          final Rank rank
  ) {
    this.uuid = uuid;
    this.rank = rank;
  }

  public UUID getUuid() {
    return uuid;
  }

  public Rank getRank() {
    return rank;
  }
}
