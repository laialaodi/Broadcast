package com.laialaodi.broadcast.item;

import com.laialaodi.broadcast.Broadcast;
import java.util.function.Supplier;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Broadcast.MOD_ID);

  public static final Supplier<Item> MESSAGE_ITEM_1 =
      ITEMS.register("message_item_1", () -> new MessageItem(new Item.Properties(), "1"));
  public static final Supplier<Item> MESSAGE_ITEM_2 =
      ITEMS.register("message_item_2", () -> new MessageItem(new Item.Properties(), "2"));
  public static final Supplier<Item> MESSAGE_ITEM_3 =
      ITEMS.register("message_item_3", () -> new MessageItem(new Item.Properties(), "3"));
  public static final Supplier<Item> MESSAGE_ITEM_4 =
      ITEMS.register("message_item_4", () -> new MessageItem(new Item.Properties(), "4"));
  public static final Supplier<Item> MESSAGE_ITEM_5 =
      ITEMS.register("message_item_5", () -> new MessageItem(new Item.Properties(), "5"));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
