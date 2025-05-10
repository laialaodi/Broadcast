package com.laialaodi.broadcast.block;

import com.laialaodi.broadcast.Broadcast;
import com.laialaodi.broadcast.item.ModItems;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
  public static final DeferredRegister.Blocks BLOCKS =
      DeferredRegister.createBlocks(Broadcast.MOD_ID);

  public static final DeferredBlock<MessageEntityBlock> MESSAGE_BLOCK =
      registerBlock(
          "message_block",
          () -> new MessageEntityBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

  //  public static final DeferredBlock<MessageEntityBlock> MESSAGE_BLOCK =
  //      BLOCKS.register(
  //          "message_block",
  //          () -> new MessageEntityBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

  private static DeferredBlock<MessageEntityBlock> registerBlock(
      String name, Supplier<MessageEntityBlock> blockSupplier) {
    DeferredBlock<MessageEntityBlock> register = BLOCKS.register(name, blockSupplier);
    ModItems.ITEMS.register(name, () -> new BlockItem(register.get(), new Item.Properties()));
    return register;
  }

  public static DeferredBlock<Block> registerSimpleBlock(
      String name, BlockBehaviour.Properties props) {
    DeferredBlock<Block> deferredBlock = BLOCKS.registerSimpleBlock(name, props);
    ModItems.ITEMS.register(name, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));
    return deferredBlock;
  }

  public static DeferredBlock<Block> registerSimpleBlock(
      String name, BlockBehaviour.Properties props, Item.Properties properties) {
    DeferredBlock<Block> deferredBlock = BLOCKS.registerSimpleBlock(name, props);
    ModItems.ITEMS.register(name, () -> new BlockItem(deferredBlock.get(), properties));
    return deferredBlock;
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
