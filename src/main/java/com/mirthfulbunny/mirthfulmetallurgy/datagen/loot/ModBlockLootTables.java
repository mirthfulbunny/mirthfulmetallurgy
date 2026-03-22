package com.mirthfulbunny.mirthfulmetallurgy.datagen.loot;

import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.WROUGHT_IRON_BLOCK.get());
//        this.dropSelf(ModBlocks.PIG_IRON_BLOCK.get());
        this.dropSelf(ModBlocks.BLISTER_STEEL_BLOCK.get());
//        this.dropSelf(ModBlocks.MILD_STEEL_BLOCK.get());
//        this.dropSelf(ModBlocks.STAINLESS_STEEL_BLOCK.get());
//        this.dropSelf(ModBlocks.MANGANESE_STEEL_BLOCK.get());
//        this.dropSelf(ModBlocks.HIGH_SPEED_STEEL_BLOCK.get());

        this.dropSelf(ModBlocks.BLOOMERY.get());
        this.dropSelf(ModBlocks.HAMMER_TABLE.get());
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
