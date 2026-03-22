package com.mirthfulbunny.mirthfulmetallurgy.recipe;

import com.google.gson.JsonObject;
import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HammeringRecipe implements Recipe<Container> {
    private final Ingredient inputItem;
    private final Integer ingredientCount;
    private final ItemStack primaryOutput;
    private final ItemStack secondaryOutput;
    private final ResourceLocation id;

    public HammeringRecipe(Ingredient inputItem, Integer ingredientCount, ItemStack primaryOutput, ItemStack secondaryOutput, ResourceLocation id) {
        this.inputItem = inputItem;
        this.ingredientCount = ingredientCount;
        this.primaryOutput = primaryOutput;
        this.secondaryOutput = secondaryOutput;
        this.id = id;
    }

    @Override
    public boolean matches(@NotNull Container pContainer, @NotNull Level pLevel) {
        ItemStack input = pContainer.getItem(0);
        return this.inputItem.test(input) && input.getCount() >= this.ingredientCount;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container pContainer, @NotNull RegistryAccess pRegistryAccess) {
        return primaryOutput.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess pRegistryAccess) {
        return primaryOutput.copy();
    }

    public NonNullList<ItemStack> getResults() {
        return NonNullList.of(ItemStack.EMPTY, primaryOutput.copy(), secondaryOutput.copy());
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    public Integer getIngredientCount() {
        return ingredientCount;
    }

    public Ingredient getInputItem() {
        return inputItem;
    }

    public ItemStack getPrimaryOutput() {
        return primaryOutput;
    }

    public ItemStack getSecondaryOutput() {
        return secondaryOutput;
    }

    public static class Serializer implements RecipeSerializer<HammeringRecipe> {
        public static final HammeringRecipe.Serializer INSTANCE = new HammeringRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(MirthfulMetallurgy.MODID, "hammering");


        @Override
        public @NotNull HammeringRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
            Ingredient ingredient = Ingredient.fromJson(pSerializedRecipe.get("ingredient"));
            int ingredientCount = GsonHelper.getAsInt(pSerializedRecipe.getAsJsonObject("ingredient"), "count", 1);
            ItemStack primaryOutput = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "primaryOutput"));
            ItemStack secondaryOutput = pSerializedRecipe.has("secondaryOutput") ?
                    ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "secondaryOutput"))
                    : ItemStack.EMPTY;

            return new HammeringRecipe(ingredient, ingredientCount, primaryOutput, secondaryOutput, pRecipeId);
        }

        @Override
        public @Nullable HammeringRecipe fromNetwork(@NotNull ResourceLocation pRecipeId, @NotNull FriendlyByteBuf pBuffer) {
            // Order must match toNetwork exactly
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            int count = pBuffer.readInt();
            ItemStack primary = pBuffer.readItem();
            ItemStack secondary = pBuffer.readItem();

            return new HammeringRecipe(ingredient, count, primary, secondary, pRecipeId);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf pBuffer, @NotNull HammeringRecipe pRecipe) {
            pRecipe.getInputItem().toNetwork(pBuffer);
            pBuffer.writeInt(pRecipe.getIngredientCount());
            pBuffer.writeItem(pRecipe.getPrimaryOutput());
            pBuffer.writeItem(pRecipe.getSecondaryOutput());
        }
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Type implements RecipeType<HammeringRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "hammering";
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }
}
