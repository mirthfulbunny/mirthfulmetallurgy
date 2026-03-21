package com.mirthfulbunny.mirthfulmetallurgy.datagen;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, MirthfulMetallurgy.MODID);
    }

    @Override
    protected void start() {

    }
}
