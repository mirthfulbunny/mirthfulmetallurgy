package com.mirthfulbunny.mirthfulmetallurgy.fluid;

import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import com.mirthfulbunny.mirthfulmetallurgy.fluid.types.ModFluidTypes;
import com.mirthfulbunny.mirthfulmetallurgy.item.ModItems;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class MoltenSlagFluid {

    public static ForgeFlowingFluid.Source SOURCE = new ForgeFlowingFluid.Source(makeProperties());
    public static ForgeFlowingFluid.Flowing FLOWING = new ForgeFlowingFluid.Flowing(makeProperties());

    private static ForgeFlowingFluid.Properties makeProperties() {
        return new ForgeFlowingFluid.Properties(
                ModFluidTypes.MOLTEN_SLAG_TYPE,
                ModFluids.MOLTEN_SLAG_SOURCE,
                ModFluids.MOLTEN_SLAG_FLOWING)
                .bucket(ModItems.MOLTEN_SLAG_BUCKET)
                .block(ModBlocks.MOLTEN_SLAG_BLOCK);
    }
}
