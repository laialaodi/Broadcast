package com.laialaodi.broadcast.item;

import net.minecraft.world.item.Item;

public class MessageItem extends Item {
  private final String message;

  public MessageItem(Properties properties, String message) {
    super(properties);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
