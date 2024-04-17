package net.findsnow.ellemobsplenty.item;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  public static final DeferredRegister<Item> ITEMS =
          DeferredRegister.create(ForgeRegistries.ITEMS, ElleMobsPlenty.MOD_ID);

  public static final RegistryObject<Item> NEPHRITE = ITEMS.register("nephrite",
          () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> RAW_NEPHRITE = ITEMS.register("raw_nephrite",
          () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> RAW_CRAB_MEAT = ITEMS.register("raw_crab_meat",
          () -> new Item(new Item.Properties().food(ModFoodProperties.RAW_CRAB_MEAT)));

  public static final RegistryObject<Item> COOKED_CRAB_MEAT = ITEMS.register("cooked_crab_meat",
          () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_CRAB_MEAT)));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }

}
