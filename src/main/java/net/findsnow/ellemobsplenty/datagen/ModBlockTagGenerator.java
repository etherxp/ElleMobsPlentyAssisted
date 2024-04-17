package net.findsnow.ellemobsplenty.datagen;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

  public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, ElleMobsPlenty.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider pProvider) {
    // Add Tags Here

    this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.NEPHRITE_BLOCK.get(),
                    ModBlocks.NEPHRITE_ORE.get(),
                    ModBlocks.DEEPSLATE_NEPHRITE_ORE.get(),
                    ModBlocks.RAW_NEPHRITE_BLOCK.get());
    this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.NEPHRITE_BLOCK.get(),
                    ModBlocks.NEPHRITE_ORE.get(),
                    ModBlocks.DEEPSLATE_NEPHRITE_ORE.get(),
                    ModBlocks.RAW_NEPHRITE_BLOCK.get());
  }

  @Override
  public String getName() {
    return "Block Tags";
  }
}
