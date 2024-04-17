package net.findsnow.ellemobsplenty.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
  public static final FoodProperties RAW_CRAB_MEAT = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F)
          .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 1), 0.3F).build();

  public static final FoodProperties COOKED_CRAB_MEAT = new FoodProperties.Builder().nutrition(5).saturationMod(0.8F).build();
}
