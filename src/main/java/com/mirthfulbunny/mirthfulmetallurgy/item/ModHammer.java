package com.mirthfulbunny.mirthfulmetallurgy.item;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;

public class ModHammer extends TieredItem {

    public ModHammer(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack returnedStack = itemStack.copy();
        if(!returnedStack.hurt(1, RandomSource.create(), null)) {
            return returnedStack;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
