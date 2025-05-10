package com.laialaodi.broadcast.tab;

import com.laialaodi.broadcast.Broadcast;
import com.laialaodi.broadcast.block.ModBlocks;
import com.laialaodi.broadcast.item.ModItems;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Broadcast.MOD_ID);

  public static final Supplier<CreativeModeTab> BROADCAST_TAB =
      CREATIVE_MODE_TABS.register(
          "broadcast_tab",
          () ->
              CreativeModeTab.builder()
                  .title(Component.translatable("itemGroup.broadcast"))
                  .icon(() -> new ItemStack(ModItems.MESSAGE_ITEM_1.get()))
                  .displayItems(
                      ((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MESSAGE_ITEM_1.get());
                        output.accept(ModItems.MESSAGE_ITEM_2.get());
                        output.accept(ModItems.MESSAGE_ITEM_3.get());
                        output.accept(ModItems.MESSAGE_ITEM_4.get());
                        output.accept(ModItems.MESSAGE_ITEM_5.get());
                        output.accept(ModBlocks.MESSAGE_BLOCK.get());
                      }))
                  .build());

  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
