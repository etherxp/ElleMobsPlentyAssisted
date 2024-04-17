package net.findsnow.ellemobsplenty.datagen;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.block.ModBlocks;
import net.findsnow.ellemobsplenty.block.custom.AncientFurnaceBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
  public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, ElleMobsPlenty.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    this.furnace(ModBlocks.ANCIENT_FURNACE_BLOCK.get());

    blockWithItem(ModBlocks.NEPHRITE_BLOCK);
    blockWithItem(ModBlocks.RAW_NEPHRITE_BLOCK);
    blockWithItem(ModBlocks.NEPHRITE_ORE);
    blockWithItem(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
  }

  public void blockItem(Block block) {
    this.simpleBlockItem(block, new ModelFile.ExistingModelFile(blockTexture(block), this.models().existingFileHelper));
  }

  public void furnace(Block block) {
    ModelFile furnace = models().cube(name(block), suffix(blockTexture(block), "_bottom"), suffix(blockTexture(block), "_top"), suffix(blockTexture(block), "_front"), suffix(blockTexture(block), "_back"), suffix(blockTexture(block), "_left"), suffix(blockTexture(block), "_right")).texture("particle", suffix(blockTexture(block), "_back"));
    ModelFile furnaceOn = models().cube(name(block) + "_on", suffix(blockTexture(block), "_bottom"), suffix(blockTexture(block), "_top_on"), suffix(blockTexture(block), "_front_on"), suffix(blockTexture(block), "_back"), suffix(blockTexture(block), "_left"), suffix(blockTexture(block), "_right")).texture("particle", suffix(blockTexture(block), "_back"));
    this.horizontalBlock(block, (state -> state.getValue(BlockStateProperties.LIT) ? furnaceOn : furnace));
    blockItem(block);
  }


  private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
    simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
  }

  private String name(Block block) {
    return ForgeRegistries.BLOCKS.getKey(block).getPath();
  }

  private ResourceLocation prefix(String prefix, ResourceLocation rl) {
    return new ResourceLocation(rl.getNamespace(), prefix + rl.getPath());
  }

  private ResourceLocation suffix(ResourceLocation rl, String suffix) {
    return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
  }
}
