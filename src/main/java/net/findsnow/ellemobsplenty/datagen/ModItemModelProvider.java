package net.findsnow.ellemobsplenty.datagen;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
  public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, ElleMobsPlenty.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    simpleItem(ModItems.NEPHRITE);
    simpleItem(ModItems.RAW_NEPHRITE);
    simpleItem(ModItems.RAW_CRAB_MEAT);
    simpleItem(ModItems.COOKED_CRAB_MEAT);

  }


  private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
    return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(ElleMobsPlenty.MOD_ID, "item/" + item.getId().getPath()));
  }
}
