package net.findsnow.ellemobsplenty.block;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.block.custom.AncientFurnaceBlock;
import net.findsnow.ellemobsplenty.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
  public static final DeferredRegister<Block> BLOCKS =
          DeferredRegister.create(ForgeRegistries.BLOCKS, ElleMobsPlenty.MOD_ID);

  public static final RegistryObject<Block> NEPHRITE_BLOCK = registerBlock("nephrite_block",
          () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

  public static final RegistryObject<Block> RAW_NEPHRITE_BLOCK = registerBlock("raw_nephrite_block",
          () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK)));

  public static final RegistryObject<Block> NEPHRITE_ORE = registerBlock("nephrite_ore",
          () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

  public static final RegistryObject<Block> DEEPSLATE_NEPHRITE_ORE = registerBlock("deepslate_nephrite_ore",
          () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));

  public static final RegistryObject<Block> ANCIENT_FURNACE_BLOCK = registerBlock("ancient_furnace",
          () -> new AncientFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));




  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
