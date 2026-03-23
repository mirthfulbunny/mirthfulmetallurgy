package com.mirthfulbunny.mirthfulmetallurgy.fluid.types;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class MoltenPigIronFluidType extends FluidType {
    public MoltenPigIronFluidType() {
        super(FluidType.Properties.create()
                .descriptionId("fluid.mirthfulmetallurgy.molten_pig_iron")
                .canPushEntity(false)
                .canSwim(false)
                .lightLevel(15) // Makes it glow like lava
                .density(3000)
                .viscosity(6000)
                .temperature(1500));
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            // Use vanilla lava textures as a placeholder, or your own custom ones
            private static final ResourceLocation STILL = new ResourceLocation(MirthfulMetallurgy.MODID, "block/molten_pig_iron_still");
            private static final ResourceLocation FLOWING = new ResourceLocation(MirthfulMetallurgy.MODID, "block/molten_pig_iron_flow");

            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING;
            }

            @Override
            public int getTintColor() {
                // This tints the texture. 0xFF is full opacity.
                // This hex code is a bright pig-iron orange/pink.
                return 0xFFFF7B54;
            }
        });
    }
}
