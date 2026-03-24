package com.mirthfulbunny.mirthfulmetallurgy.fluid.types;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public abstract class ModBaseMoltenFluidType extends FluidType {
    public ModBaseMoltenFluidType(String descriptionId, int lightLevel) {
        super(FluidType.Properties.create()
                .descriptionId(descriptionId)
                .canPushEntity(false)
                .canSwim(false)
                .lightLevel(lightLevel) // Makes it glow like lava
                .density(3000)
                .viscosity(6000)
                .temperature(1500));
    }

    public abstract int tint();

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            // Use vanilla lava textures as a placeholder, or your own custom ones
            private static final ResourceLocation STILL = new ResourceLocation("mirthfulmetallurgy", "block/base_still");
            private static final ResourceLocation FLOWING = new ResourceLocation("mirthfulmetallurgy", "block/base_flow");

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
                return tint();
            }
        });
    }
}
