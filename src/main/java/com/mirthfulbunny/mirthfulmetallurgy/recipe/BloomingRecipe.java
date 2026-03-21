package com.mirthfulbunny.mirthfulmetallurgy.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BloomingRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final NonNullList<Integer> ingredientCounts;
    private final ItemStack output;
    private final int bloomTime;
    private final ResourceLocation id;

    public BloomingRecipe(NonNullList<Ingredient> inputItems, NonNullList<Integer> ingredientCounts, ItemStack output, int bloomTime, ResourceLocation id) {
        this.inputItems = inputItems;
        this.ingredientCounts = ingredientCounts;
        this.output = output;
        this.bloomTime = bloomTime;
        this.id = id;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        if (inputItems.size() < 2) return false;

        return inputItems.get(0).test(pContainer.getItem(0)) &&
                pContainer.getItem(0).getCount() >= ingredientCounts.get(0) &&
                inputItems.get(1).test(pContainer.getItem(1)) &&
                pContainer.getItem(1).getCount() >= ingredientCounts.get(1);
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    public NonNullList<Integer> getIngredientCounts() {
        return ingredientCounts;
    }

    // A getter to help the Block Entity know how much to consume
    public int getIngredientCount(int slot) {
        return slot < ingredientCounts.size() ? ingredientCounts.get(slot) : 1;
    }

    public int getBloomTime() {
        return bloomTime;
    }


    @Override
    public @NotNull ItemStack assemble(@NotNull SimpleContainer pContainer, @NotNull RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<BloomingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "blooming";
    }

    public static class Serializer implements RecipeSerializer<BloomingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(MirthfulMetallurgy.MODID, "blooming");

        @Override
        public @NotNull BloomingRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);
            NonNullList<Integer> counts = NonNullList.withSize(2, 1);

            for(int i = 0; i < inputs.size(); i++) {
                JsonObject obj = ingredients.get(i).getAsJsonObject();
                inputs.set(i, Ingredient.fromJson(obj));
                counts.set(i, GsonHelper.getAsInt(obj, "count", 1)); // Default to 1 if missing
            }

            int bloomTime = GsonHelper.getAsInt(pSerializedRecipe, "bloom_time", 200);

            return new BloomingRecipe(inputs, counts, output, bloomTime, pRecipeId);
        }

        @Override
        public @Nullable BloomingRecipe fromNetwork(@NotNull ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
            NonNullList<Integer> counts = NonNullList.withSize(2, 1);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            for(int i = 0; i < inputs.size(); i++) {
                counts.set(1, pBuffer.readInt());
            }

            int bloomTime = pBuffer.readInt();

            ItemStack output = pBuffer.readItem();
            return new BloomingRecipe(inputs, counts, output, bloomTime, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, BloomingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.inputItems.size());

            for (Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            for(int count: pRecipe.getIngredientCounts()) {
                pBuffer.writeInt(count);
            }

            pBuffer.writeInt(pRecipe.getBloomTime());

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
