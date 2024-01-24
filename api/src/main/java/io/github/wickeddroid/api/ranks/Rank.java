package io.github.wickeddroid.api.ranks;

public enum Rank {
  OWNER("", "", "892385739659178024", "#FF5E5E"),
  ADMIN("", "", "892532245108256790", "#FF5E5E"),
  MOD("", "", "897731311735828480", "#FF5E5E"),
  HOST("", "", "1104653920455884820", "#FF5E5E"),
  DEVELOPER("", "", "1112270949367173121", "#FF5E5E"),
  DARK_QUEEN("", "Esto es una papu prueba", "1131771169729675264", "#FF5E5E",
          "uhc.banner",
          "uhc.rename",
          "uhc.relore"),
  DARK_KING("", "Esto es una papu prueba", "1131771167242469396", "#FF5E5E",
          "uhc.banner",
          "uhc.rename",
          "uhc.relore"),
  DARK_PRINCESS("", "Esto es una papu prueba", "1131771152235245609", "#FF5E5E",
          "uhc.banner",
          "uhc.rename"),
  DARK_PRINCE("", "Esto es una papu prueba", "1131771163522125855", "#FF5E5E",
          "uhc.banner",
          "uhc.rename"),
  USER("", "", "892533124083384361", "#FF5E5E");

  private final String prefix;
  private final String description;
  private final String[] permissions;
  private final String color;
  private final String id;

  Rank(
          final String prefix,
          final String description,
          final String id,
          final String color,
          final String... permissions
  ) {
    this.prefix = prefix;
    this.description = description;
    this.id = id;
    this.color = color;
    this.permissions = permissions;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getColor() {
    return color;
  }

  public String[] getPermissions() {
    return permissions;
  }
}
