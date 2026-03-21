package com.mirthfulbunny.mirthfulmetallurgy.item;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    // These are here as reference
//    WOOD(0, 59, 2.0F, 0.0F, 15, () -> {
//        return Ingredient.of(ItemTags.PLANKS);
//    }),
//    STONE(1, 131, 4.0F, 1.0F, 5, () -> {
//        return Ingredient.of(ItemTags.STONE_TOOL_MATERIALS);
//    }),
//    IRON(2, 250, 6.0F, 2.0F, 14, () -> {
//        return Ingredient.of(Items.IRON_INGOT);
//    }),
//    DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {
//        return Ingredient.of(Items.DIAMOND);
//    }),
//    GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
//        return Ingredient.of(Items.GOLD_INGOT);
//    }),
//    NETHERITE(4, 2031, 9.0F, 4.0F, 15, () -> {
//        return Ingredient.of(Items.NETHERITE_INGOT);
//    });

    public static final Tier WROUGHT_IRON = TierSortingRegistry.registerTier(
            new ForgeTier(2, 750, 5f, 1.5f, 7,
                    BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.WROUGHT_IRON_INGOT.get())),
            new ResourceLocation(MirthfulMetallurgy.MODID, "wrought_iron"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier BLISTER_STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(2, 200, 6.5f, 2.5f, 12,
                    BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.BLISTER_STEEL_INGOT.get())),
            new ResourceLocation(MirthfulMetallurgy.MODID, "blister_steel"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

//    public static final Tier MILD_STEEL = TierSortingRegistry.registerTier(
//            new ForgeTier(3, 1561, 8f, 3f, 10,
//                    BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.BLISTER_STEEL_INGOT.get())),
//            new ResourceLocation(MirthfulMetallurgy.MODID, "mild_steel"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
}
