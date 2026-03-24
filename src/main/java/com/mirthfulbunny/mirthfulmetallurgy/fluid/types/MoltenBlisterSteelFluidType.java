package com.mirthfulbunny.mirthfulmetallurgy.fluid.types;

public class MoltenBlisterSteelFluidType extends ModBaseMoltenFluidType{
    public MoltenBlisterSteelFluidType() {
        super("fluid.mirthfulmetallurgy.molten_blister_steel", 15);
    }

    @Override
    public int tint() {
        return 0xFFFF8000;
    }
}
