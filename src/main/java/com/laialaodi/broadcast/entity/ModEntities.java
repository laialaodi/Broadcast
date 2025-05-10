package com.laialaodi.broadcast.entity;

import com.laialaodi.broadcast.Broadcast;
import com.laialaodi.broadcast.block.ModBlocks;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
      DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Broadcast.MOD_ID);

  public static void register(IEventBus eventBus) {
    BLOCK_ENTITY_TYPES.register(eventBus);
  }  public static final Supplier<BlockEntityType<MessageBlockEntity>> MESSAGE_BLOCK_ENTITY =
      BLOCK_ENTITY_TYPES.register(
          "message_block_entity",
          () ->
              BlockEntityType.Builder.of(MessageBlockEntity::new, ModBlocks.MESSAGE_BLOCK.get())
                  .build(null));


}
