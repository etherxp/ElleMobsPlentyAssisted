package net.findsnow.ellemobsplenty.datagen.custom;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.recipe.AncientFurnaceRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class AncientFurnaceRecipeBuilder implements RecipeBuilder {
  private final Item result;
  private final Ingredient ingredient;
  private final int count;
  private final Advancement.Builder advancement = Advancement.Builder.advancement();
  private final float experience;
  private final int cookingTime;

  public AncientFurnaceRecipeBuilder(ItemLike ingredient, ItemLike result, int count, float experience, int cookingTime) {
    this.ingredient = Ingredient.of(ingredient);
    this.result = result.asItem();
    this.count = count;
    this.experience = experience;
    this.cookingTime = cookingTime;
  }

  @Override
  public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
    this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
    return this;
  }

  @Override
  public RecipeBuilder group(@Nullable String pGroupName) {
    return this;
  }

  @Override
  public Item getResult() {
    return result;
  }

  @Override
  public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
    this.advancement.parent(new ResourceLocation("recipes/root"))
            .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
            .rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);

    pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.result, this.count, this.ingredient,
            this.experience, this.cookingTime,this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/"
            + pRecipeId.getPath())));

  }

  public static class Result implements FinishedRecipe {
    private final ResourceLocation id;
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final Advancement.Builder advancement;
    private final ResourceLocation advancementId;
    private final float experience;
    private final int cookingTime;


    public Result(ResourceLocation pId, Item pResult, int pCount, Ingredient ingredient, float experience, int cookingTime ,Advancement.Builder pAdvancement,
                  ResourceLocation pAdvancementId) {
      this.id = pId;
      this.result = pResult;
      this.count = pCount;
      this.ingredient = ingredient;
      this.experience = experience;
      this.advancement = pAdvancement;
      this.advancementId = pAdvancementId;
      this.cookingTime = cookingTime;
    }

    @Override
    public void serializeRecipeData(JsonObject pJson) {
      JsonArray jsonarray = new JsonArray();
      jsonarray.add(ingredient.toJson());

      pJson.add("ingredients", jsonarray);
      JsonObject jsonobject = new JsonObject();
      jsonobject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
      if (this.count > 1) {
        jsonobject.addProperty("count", this.count);
      }

      pJson.add("output", jsonobject);
      pJson.addProperty("experience", this.experience);
      pJson.addProperty("cookingTime", this.cookingTime);
    }

    @Override
    public ResourceLocation getId() {
      return new ResourceLocation(ElleMobsPlenty.MOD_ID,
              ForgeRegistries.ITEMS.getKey(this.result).getPath() + "_from_ancient_furnace");
    }

    @Override
    public RecipeSerializer<?> getType() {
      return AncientFurnaceRecipe.Serializer.INSTANCE;
    }

    @javax.annotation.Nullable
    public JsonObject serializeAdvancement() {
      return this.advancement.serializeToJson();
    }

    @javax.annotation.Nullable
    public ResourceLocation getAdvancementId() {
      return this.advancementId;
    }
  }
}
