package com.mirthfulbunny.mirthfulmetallurgy.datagen;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import com.mirthfulbunny.mirthfulmetallurgy.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider  extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIRE_CLAY.get())
                .requires(Items.CLAY_BALL.asItem(), 2)
                .requires(Items.SAND.asItem(), 2)
                .unlockedBy(getHasName(Items.SAND.asItem()), has(Items.SAND.asItem()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOOMERY.get())
                .pattern("FFF")
                .pattern("F F")
                .pattern("FFF")
                .define('F', ModItems.FIRE_CLAY_BRICK.get())
                .unlockedBy(getHasName(ModItems.FIRE_CLAY_BRICK.get()), has(ModItems.FIRE_CLAY_BRICK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.HAMMER_TABLE.get())
                .requires(Items.SMITHING_TABLE.asItem())
                .unlockedBy(getHasName(Items.SMITHING_TABLE.asItem()), has(Items.SMITHING_TABLE.asItem()))
                .save(pWriter);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SMITHING_TABLE.asItem())
//                .requires(ModBlocks.HAMMER_TABLE.get())
//                .unlockedBy(getHasName(ModBlocks.HAMMER_TABLE.get()), has(ModBlocks.HAMMER_TABLE.get()))
//                .save(pWriter);

        oreSmelting(pWriter, List.of(ModItems.FIRE_CLAY.get()), RecipeCategory.MISC, ModItems.FIRE_CLAY_BRICK.get(),
                0.25f, 200, "fire_clay");

        oreSmelting(pWriter, List.of(ModItems.PRECARBURIZED_WROUGHT_IRON_INGOT.get()), RecipeCategory.MISC, ModItems.BLISTER_STEEL_INGOT.get(),
                0.25f, 200, "blister_steel");

        oreBlasting(pWriter, List.of(ModItems.PRECARBURIZED_WROUGHT_IRON_INGOT.get()), RecipeCategory.MISC, ModItems.BLISTER_STEEL_INGOT.get(),
                0.25f, 200, "blister_steel");

        craftPickaxe(pWriter, ModItems.WROUGHT_IRON_INGOT.get(), ModItems.WROUGHT_IRON_PICKAXE.get());
        craftAxe(pWriter, ModItems.WROUGHT_IRON_INGOT.get(), ModItems.WROUGHT_IRON_AXE.get());
        craftHoe(pWriter, ModItems.WROUGHT_IRON_INGOT.get(), ModItems.WROUGHT_IRON_HOE.get());
        craftShovel(pWriter, ModItems.WROUGHT_IRON_INGOT.get(), ModItems.WROUGHT_IRON_SHOVEL.get());
        craftSword(pWriter, ModItems.WROUGHT_IRON_INGOT.get(), ModItems.WROUGHT_IRON_SWORD.get());

        craftPickaxe(pWriter, ModItems.BLISTER_STEEL_INGOT.get(), ModItems.BLISTER_STEEL_PICKAXE.get());
        craftAxe(pWriter, ModItems.BLISTER_STEEL_INGOT.get(), ModItems.BLISTER_STEEL_AXE.get());
        craftHoe(pWriter, ModItems.BLISTER_STEEL_INGOT.get(), ModItems.BLISTER_STEEL_HOE.get());
        craftShovel(pWriter, ModItems.BLISTER_STEEL_INGOT.get(), ModItems.BLISTER_STEEL_SHOVEL.get());
        craftSword(pWriter, ModItems.BLISTER_STEEL_INGOT.get(), ModItems.BLISTER_STEEL_SWORD.get());
    }

    protected static void craftPickaxe(@NotNull Consumer<FinishedRecipe> pWriter, Item material, Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("MMM")
                .pattern(" S ")
                .pattern(" S ")
                .define('M', material)
                .define('S', Items.STICK.asItem())
                .unlockedBy(getHasName(material), has(material))
                .save(pWriter);
    }

    protected static void craftAxe(@NotNull Consumer<FinishedRecipe> pWriter, Item material, Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("MM")
                .pattern("MS")
                .pattern(" S")
                .define('M', material)
                .define('S', Items.STICK.asItem())
                .unlockedBy(getHasName(material), has(material))
                .save(pWriter);
    }

    protected static void craftSword(@NotNull Consumer<FinishedRecipe> pWriter, Item material, Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("M")
                .pattern("M")
                .pattern("S")
                .define('M', material)
                .define('S', Items.STICK.asItem())
                .unlockedBy(getHasName(material), has(material))
                .save(pWriter);
    }

    protected static void craftShovel(@NotNull Consumer<FinishedRecipe> pWriter, Item material, Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("M")
                .pattern("S")
                .pattern("S")
                .define('M', material)
                .define('S', Items.STICK.asItem())
                .unlockedBy(getHasName(material), has(material))
                .save(pWriter);
    }

    protected static void craftHoe(@NotNull Consumer<FinishedRecipe> pWriter, Item material, Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("MM")
                .pattern(" S")
                .pattern(" S")
                .define('M', material)
                .define('S', Items.STICK.asItem())
                .unlockedBy(getHasName(material), has(material))
                .save(pWriter);
    }

    protected static void oreSmelting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                      List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory,
                                      @NotNull ItemLike pResult, float pExperience,
                                      int pCookingTIme, @NotNull String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                      List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory,
                                      @NotNull ItemLike pResult, float pExperience,
                                      int pCookingTime, @NotNull String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                     @NotNull RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory,
                                     @NotNull ItemLike pResult, float pExperience, int pCookingTime,
                                     @NotNull String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  MirthfulMetallurgy.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
