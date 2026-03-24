package com.mirthfulbunny.mirthfulmetallurgy.fluid.types;

public class MoltenStainlessSteelFluidType extends ModBaseMoltenFluidType{
    public MoltenStainlessSteelFluidType() {
        super("fluid.mirthfulmetallurgy.molten_stainless_steel", 15);
    }

    @Override
    public int tint() {
        return 0xFFFFF0AD;
    }
}
