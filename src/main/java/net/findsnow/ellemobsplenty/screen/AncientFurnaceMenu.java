package net.findsnow.ellemobsplenty.screen;

import net.findsnow.ellemobsplenty.item.ModItems;
import net.findsnow.ellemobsplenty.recipe.AncientFurnaceRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;

public class AncientFurnaceMenu extends AbstractFurnaceMenu {
  protected AncientFurnaceMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf pBuffer) {
    this(pContainerId, pPlayerInventory);
  }

  public AncientFurnaceMenu(int pContainerId, Inventory pPlayerInventory, Container container, ContainerData containerData) {
    super(ModMenuTypes.ANCIENT_FURNACE_MENU.get(), AncientFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory, container, containerData);
  }

  public AncientFurnaceMenu(int pContainerId, Inventory pPlayerInventory) {
    super(ModMenuTypes.ANCIENT_FURNACE_MENU.get(), AncientFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory);
  }

  @Override
  protected boolean canSmelt(ItemStack pStack) {
    return pStack.getItem() == ModItems.RAW_NEPHRITE.get();
  }

  @Override
  protected boolean isFuel(ItemStack pStack) {
    return true;
  }
}
