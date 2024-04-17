package net.findsnow.ellemobsplenty.entity;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.item.ModItems;
import net.findsnow.ellemobsplenty.recipe.AncientFurnaceRecipe;
import net.findsnow.ellemobsplenty.screen.AncientFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class AncientFurnaceBlockEntity extends AbstractFurnaceBlockEntity  {
  private Map<Item, Integer> BURN_DURATION_MAP =
          Map.of(Items.COAL, 100,
                  Items.CHARCOAL, 100);

  public AncientFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(ModBlockEntities.ANCIENT_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, AncientFurnaceRecipe.Type.INSTANCE);
  }

  @Override
  protected Component getDefaultName() {
    return Component.translatable("block.ellemobsplenty.ancient_furnace");
  }

  @Override
  protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
    return new AncientFurnaceMenu(pContainerId, pInventory, this, dataAccess);
  }

  @Override
  protected int getBurnDuration(ItemStack pFuel) {
    return BURN_DURATION_MAP.getOrDefault(pFuel.getItem(), 0);
  }
}
