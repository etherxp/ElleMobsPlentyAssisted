package net.findsnow.ellemobsplenty.screen;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.recipe.AncientFurnaceRecipeBookComponent;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AncientFurnaceScreen extends AbstractFurnaceScreen<AncientFurnaceMenu> {
  private static final ResourceLocation TEXTURE = new ResourceLocation(ElleMobsPlenty.MOD_ID, "textures/gui/ancient_furnace.png");

  public AncientFurnaceScreen(AncientFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
    super(pMenu, new AncientFurnaceRecipeBookComponent(), pPlayerInventory, pTitle, TEXTURE);
  }
}
