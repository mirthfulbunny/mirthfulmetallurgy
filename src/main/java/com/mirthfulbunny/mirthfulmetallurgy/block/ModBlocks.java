package com.mirthfulbunny.mirthfulmetallurgy.block;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import com.mirthfulbunny.mirthfulmetallurgy.fluid.ModFluids;
import com.mirthfulbunny.mirthfulmetallurgy.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MirthfulMetallurgy.MODID);

    public static final RegistryObject<Block> WROUGHT_IRON_BLOCK = registerBlock("wrought_iron_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PIG_IRON_BLOCK = registerBlock("pig_iron_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BLISTER_STEEL_BLOCK = registerBlock("blister_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> MILD_STEEL_BLOCK = registerBlock("mild_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STAINLESS_STEEL_BLOCK = registerBlock("stainless_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> MANGANESE_STEEL_BLOCK = registerBlock("manganese_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> HIGH_SPEED_STEEL_BLOCK = registerBlock("high_speed_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> FIRECLAY_BRICKS = registerBlock("fireclay_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> FIRECLAY_BRICK_SLAB = registerBlock("fireclay_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)));

    public static final RegistryObject<LiquidBlock> MOLTEN_PIG_IRON_BLOCK = BLOCKS.register("molten_pig_iron_block",
            () -> new LiquidBlock(ModFluids.MOLTEN_PIG_IRON_SOURCE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_WROUGHT_IRON_BLOCK = BLOCKS.register("molten_wrought_iron_block",
            () -> new LiquidBlock(ModFluids.MOLTEN_WROUGHT_IRON_SOURCE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_BLISTER_STEEL_BLOCK = BLOCKS.register("molten_blister_steel_block",
            () -> new LiquidBlock(ModFluids.MOLTEN_BLISTER_STEEL_SOURCE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_MILD_STEEL_BLOCK = BLOCKS.register("molten_mild_steel_block",
            () -> new LiquidBlock(ModFluids.MOLTEN_MILD_STEEL_SOURCE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_STAINLESS_STEEL_BLOCK = BLOCKS.register("molten_stainless_steel_block",
            () -> new LiquidBlock(ModFluids.MOLTEN_STAINLESS_STEEL_SOURCE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_MANGANESE_BLOCK = BLOCKS.register("molten_manganese_block",
            () -> new LiquidBlock(ModFluids.MOLTEN_MANGANESE_STEEL_SOURCE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_HIGH_SPEED_STEEL_BLOCK = BLOCKS.register("molten_high_speed_steel_block",
            () -> new LiquidBlock(ModFluids.MOLTEN_HIGH_SPEED_STEEL_SOURCE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));
    public static final RegistryObject<LiquidBlock> MOLTEN_SLAG_BLOCK = BLOCKS.register("molten_slag_block",
            () -> new LiquidBlock(ModFluids.MOLTEN_SLAG_SOURCE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));


    public static final RegistryObject<Block> BLOOMERY = registerBlock("bloomery",
            () -> new BloomeryBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> HAMMER_TABLE = registerBlock("hammer_table",
            () -> new HammerTableBlock(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
