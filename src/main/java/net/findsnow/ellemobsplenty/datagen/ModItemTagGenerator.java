package net.findsnow.ellemobsplenty.datagen;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
  public ModItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
    super(output, pLookupProvider, pBlockTags, ElleMobsPlenty.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider pProvider) {
    // Add Tags Here

  }

  @Override
  public String getName() {
    return "Item Tags";
  }
}