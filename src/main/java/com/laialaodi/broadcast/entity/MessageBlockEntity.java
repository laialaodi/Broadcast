package com.laialaodi.broadcast.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MessageBlockEntity extends BlockEntity {
  private String lastMessage = "";

  public MessageBlockEntity(BlockPos pos, BlockState state) {
    super(ModEntities.MESSAGE_BLOCK_ENTITY.get(), pos, state);
  }

  @Override
  public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
    super.loadAdditional(tag, registries);
    this.lastMessage = tag.getString("lastMessage");
  }

  @Override
  public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
    super.saveAdditional(tag, registries);
    tag.putString("lastMessage", this.lastMessage);
  }

  public String getLastMessage() {
    return lastMessage;
  }

  public void setLastMessage(String message) {
    lastMessage = message;
    //    setChanged();
  }
}
