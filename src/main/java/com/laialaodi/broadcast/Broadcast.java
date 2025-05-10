package com.laialaodi.broadcast;

import com.laialaodi.broadcast.block.ModBlocks;
import com.laialaodi.broadcast.entity.ModEntities;
import com.laialaodi.broadcast.event.EventHandlers;
import com.laialaodi.broadcast.item.ModItems;
import com.laialaodi.broadcast.tab.ModTabs;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Broadcast.MOD_ID)
public class Broadcast {
  // Define mod id in a common place for everything to reference
  public static final String MOD_ID = "broadcast";
  // Directly reference a slf4j logger
  private static final Logger LOGGER = LogUtils.getLogger();

  // The constructor for the mod class is the first code that is run when your mod is loaded.
  // FML will recognize some parameter types like IEventBus or ModContainer and pass them in
  // automatically.
  public Broadcast(IEventBus modEventBus, ModContainer modContainer) {
    ModItems.register(modEventBus);
    ModBlocks.register(modEventBus);
    ModTabs.register(modEventBus);
    ModEntities.register(modEventBus);
    NeoForge.EVENT_BUS.addListener(EventHandlers::onRightClickBlock);
  }
}
