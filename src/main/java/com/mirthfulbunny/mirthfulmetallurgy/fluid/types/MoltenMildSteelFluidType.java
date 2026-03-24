package com.mirthfulbunny.mirthfulmetallurgy.fluid.types;

public class MoltenMildSteelFluidType extends ModBaseMoltenFluidType{
    public MoltenMildSteelFluidType() {
        super("fluid.mirthfulmetallurgy.molten_mild_steel", 15);
    }

    @Override
    public int tint() {
        return 0xFFFF9D00;
    }
}
