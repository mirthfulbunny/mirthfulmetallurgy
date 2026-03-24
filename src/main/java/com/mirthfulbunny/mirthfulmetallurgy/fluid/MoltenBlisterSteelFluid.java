package com.mirthfulbunny.mirthfulmetallurgy.fluid;

import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import com.mirthfulbunny.mirthfulmetallurgy.fluid.types.ModFluidTypes;
import com.mirthfulbunny.mirthfulmetallurgy.item.ModItems;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class MoltenBlisterSteelFluid {
    public static ForgeFlowingFluid.Source SOURCE = new ForgeFlowingFluid.Source(makeProperties());
    public static ForgeFlowingFluid.Flowing FLOWING = new ForgeFlowingFluid.Flowing(makeProperties());

    private static ForgeFlowingFluid.Properties makeProperties() {
        return new ForgeFlowingFluid.Properties(
                ModFluidTypes.MOLTEN_BLISTER_STEEL_TYPE,
                ModFluids.MOLTEN_BLISTER_STEEL_SOURCE,
                ModFluids.MOLTEN_BLISTER_STEEL_FLOWING)
                .bucket(ModItems.MOLTEN_BLISTER_STEEL_BUCKET)
                .block(ModBlocks.MOLTEN_BLISTER_STEEL_BLOCK);
    }
}
