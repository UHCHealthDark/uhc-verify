package io.github.wickeddroid.plugin.util;

import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.Random;

public class PluginUtil {
  private static final Random RANDOM = new Random();
  private static final int CODE_LENGTH = 6;
  public static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

  public static String generateVerificationCode() {
    final var codeBuilder = new StringBuilder();

    for (int i = 0; i < CODE_LENGTH; i++) {
      int digit = RANDOM.nextInt(10);
      codeBuilder.append(digit);
    }

    return codeBuilder.toString();
  }
}
