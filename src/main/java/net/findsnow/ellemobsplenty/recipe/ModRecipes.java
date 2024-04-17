package net.findsnow.ellemobsplenty.recipe;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
  public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
          DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ElleMobsPlenty.MOD_ID);

  public static final RegistryObject<RecipeSerializer<AncientFurnaceRecipe>> ANCIENT_FURNACE_SERIALIZER =
          SERIALIZERS.register("ancient_furnace", () -> AncientFurnaceRecipe.Serializer.INSTANCE);

  public static void register(IEventBus eventBus) {
    SERIALIZERS.register(eventBus);
  }
}
