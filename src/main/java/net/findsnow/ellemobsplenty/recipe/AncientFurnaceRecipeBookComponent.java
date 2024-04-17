package net.findsnow.ellemobsplenty.recipe;

import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Set;

public class AncientFurnaceRecipeBookComponent extends AbstractFurnaceRecipeBookComponent {
  @Override
  protected Set<Item> getFuelItems() {
    return Set.of(Items.COAL, Items.CHARCOAL);
  }
}
