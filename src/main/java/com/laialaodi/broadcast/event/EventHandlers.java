package com.laialaodi.broadcast.event;

import com.laialaodi.broadcast.block.ModBlocks;
import com.laialaodi.broadcast.entity.MessageBlockEntity;
import com.laialaodi.broadcast.item.MessageItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class EventHandlers {
  public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
    Level level = event.getLevel();
    Player player = event.getEntity();
    BlockPos blockPos = event.getPos();
    ItemStack itemStack = player.getMainHandItem();

    if (!level.isClientSide && level.getBlockState(blockPos).is(ModBlocks.MESSAGE_BLOCK)) {
      BlockEntity blockEntity = level.getBlockEntity(blockPos);
      if (blockEntity instanceof MessageBlockEntity messageBlockEntity) {
        if (itemStack.getItem() instanceof MessageItem messageItem) {
          String message = messageItem.getMessage();
          level
              .getServer()
              .getPlayerList()
              .getPlayers()
              .forEach(p -> p.displayClientMessage(Component.literal(message), true));
          messageBlockEntity.setLastMessage(message);
          event.setCanceled(true);
        } else if (itemStack.isEmpty()) {
          player.displayClientMessage(Component.literal(messageBlockEntity.getLastMessage()), true);
        }
      }
    }
  }
}
