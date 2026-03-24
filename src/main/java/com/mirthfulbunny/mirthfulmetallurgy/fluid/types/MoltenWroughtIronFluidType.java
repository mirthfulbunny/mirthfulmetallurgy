package com.mirthfulbunny.mirthfulmetallurgy.fluid.types;

public class MoltenWroughtIronFluidType extends ModBaseMoltenFluidType {
    public MoltenWroughtIronFluidType() {
        super("fluid.mirthfulmetallurgy.molten_pig_iron", 13);
    }

    @Override
    public int tint() {
        return 0xFFFF6A00;
    }
}
