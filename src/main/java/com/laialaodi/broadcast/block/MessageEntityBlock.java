package com.laialaodi.broadcast.block;

import com.laialaodi.broadcast.entity.MessageBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class MessageEntityBlock extends Block implements EntityBlock {
  public MessageEntityBlock(Properties properties) {
    super(properties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
    return new MessageBlockEntity(blockPos, blockState);
  }
}
