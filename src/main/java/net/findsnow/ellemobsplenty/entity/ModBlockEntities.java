package net.findsnow.ellemobsplenty.entity;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
          DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ElleMobsPlenty.MOD_ID);

  public static final RegistryObject<BlockEntityType<AncientFurnaceBlockEntity>> ANCIENT_FURNACE_BLOCK_ENTITY =
          BLOCK_ENTITIES.register("ancient_furnace_block_entity", () ->
                  BlockEntityType.Builder.of(AncientFurnaceBlockEntity::new,
                          ModBlocks.ANCIENT_FURNACE_BLOCK.get()).build(null));

  public static void register(IEventBus eventBus) {
    BLOCK_ENTITIES.register(eventBus);
  }
}
