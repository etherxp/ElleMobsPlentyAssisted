package net.findsnow.ellemobsplenty.datagen.loot;

import net.findsnow.ellemobsplenty.block.ModBlocks;
import net.findsnow.ellemobsplenty.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
  public ModBlockLootTables() {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags());
  }

  @Override
  protected void generate() {
    // BLOCKS
    this.dropSelf(ModBlocks.NEPHRITE_BLOCK.get());
    this.dropSelf(ModBlocks.RAW_NEPHRITE_BLOCK.get());
    this.dropSelf(ModBlocks.ANCIENT_FURNACE_BLOCK.get());


    // ORES
    this.add(ModBlocks.NEPHRITE_ORE.get(),
            block -> createOreDrop(ModBlocks.NEPHRITE_ORE.get(), ModItems.NEPHRITE.get()));
    this.add(ModBlocks.DEEPSLATE_NEPHRITE_ORE.get(),
            block -> createOreDrop(ModBlocks.DEEPSLATE_NEPHRITE_ORE.get(), ModItems.NEPHRITE.get()));

  }


  @Override
  protected Iterable<Block> getKnownBlocks() {
    return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
  }
}
