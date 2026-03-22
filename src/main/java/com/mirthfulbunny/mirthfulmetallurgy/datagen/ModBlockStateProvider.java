package com.mirthfulbunny.mirthfulmetallurgy.datagen;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MirthfulMetallurgy.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.WROUGHT_IRON_BLOCK);
//        blockWithItem(ModBlocks.PIG_IRON_BLOCK);
        blockWithItem(ModBlocks.BLISTER_STEEL_BLOCK);
//        blockWithItem(ModBlocks.MILD_STEEL_BLOCK);
//        blockWithItem(ModBlocks.STAINLESS_STEEL_BLOCK);
//        blockWithItem(ModBlocks.MANGANESE_STEEL_BLOCK);
//        blockWithItem(ModBlocks.HIGH_SPEED_STEEL_BLOCK);

        furnaceBlock(ModBlocks.BLOOMERY.get(), "bloomery");
        simpleBlockItem(ModBlocks.BLOOMERY.get(), models().getExistingFile(modLoc("block/bloomery")));
        simpleBlock(ModBlocks.HAMMER_TABLE.get(), models().cube(
                "hammer_table",
                modLoc("block/hammer_table_bottom"),
                modLoc("block/hammer_table_top"),
                modLoc("block/hammer_table_front"),
                modLoc("block/hammer_table_side"),
                modLoc("block/hammer_table_side"),
                modLoc("block/hammer_table_side")
        ));
        simpleBlockItem(ModBlocks.HAMMER_TABLE.get(), models().getExistingFile(modLoc("block/hammer_table")));
    }

    private void furnaceBlock(Block block, String name) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean lit = state.getValue(BlockStateProperties.LIT);
            var facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);

            // Determine which model to use based on the 'LIT' property
            String suffix = lit ? "_on" : "";
            ModelFile model = models().orientable(
                    name + suffix,
                    modLoc("block/" + name + "_side"),
                    modLoc("block/" + name + "_front" + suffix),
                    modLoc("block/" + name + "_top")
            );

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY(((int) facing.toYRot() + 180) % 360)
                    .build();
        });
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
