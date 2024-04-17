package net.findsnow.ellemobsplenty.datagen;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.block.ModBlocks;
import net.findsnow.ellemobsplenty.datagen.custom.AncientFurnaceRecipeBuilder;
import net.findsnow.ellemobsplenty.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
  private static final List<ItemLike> NEPHRITE_SMELTABLES = List.of(ModItems.RAW_NEPHRITE.get(),
          ModBlocks.NEPHRITE_ORE.get(), ModBlocks.DEEPSLATE_NEPHRITE_ORE.get(), ModBlocks.RAW_NEPHRITE_BLOCK.get());
  private static final  List<ItemLike> ELLE_COOKABLES = List.of(ModItems.COOKED_CRAB_MEAT.get(),
          ModItems.RAW_CRAB_MEAT.get());


  public ModRecipeProvider(PackOutput pOutput) {
    super(pOutput);
  }

  @Override
  protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEPHRITE_BLOCK.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', ModItems.NEPHRITE.get())
            .unlockedBy("has_nephrite", inventoryTrigger(ItemPredicate.Builder.item()
                    .of(ModItems.NEPHRITE.get()).build()))
            .save(pWriter);
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NEPHRITE.get(), 9)
            .requires(ModBlocks.NEPHRITE_BLOCK.get())
            .unlockedBy("has_nephrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                    .of(ModBlocks.NEPHRITE_BLOCK.get()).build()))
            .save(pWriter);
    SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_NEPHRITE.get()), RecipeCategory.MISC, ModItems.NEPHRITE.get(), 0.45f, 200);

    oreSmelting(pWriter, NEPHRITE_SMELTABLES, RecipeCategory.MISC, ModItems.NEPHRITE.get(), 0.45f, 200, "nephrite");
    oreBlasting(pWriter, NEPHRITE_SMELTABLES, RecipeCategory.MISC, ModItems.NEPHRITE.get(), 0.45f, 100, "nephrite");

    new AncientFurnaceRecipeBuilder(ModItems.RAW_NEPHRITE.get(), ModItems.NEPHRITE.get(), 1, 0.45f, 80)
            .unlockedBy("has_raw_nephrite", has(ModItems.RAW_NEPHRITE.get()))
            .save(pWriter);
  }

  protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                    float pExperience, int pCookingTIme, String pGroup) {
    oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
  }

  protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                    float pExperience, int pCookingTime, String pGroup) {
    oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
  }

  protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                   List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
    for(ItemLike itemlike : pIngredients) {
      SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
              pExperience, pCookingTime, pCookingSerializer)
              .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
              .save(pFinishedRecipeConsumer, ElleMobsPlenty.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
    }

  }

  public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, ICondition condition, RecipeBuilder recipe, ResourceLocation defaultRecipeId) {
    conditionalRecipe(consumer, category, condition, recipe, RecipeBuilder.getDefaultRecipeId(recipe.getResult()));
  }
}
