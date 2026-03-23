package com.mirthfulbunny.mirthfulmetallurgy.datagen;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import com.mirthfulbunny.mirthfulmetallurgy.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, MirthfulMetallurgy.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(FluidTags.LAVA)
                .add(ModFluids.MOLTEN_PIG_IRON_SOURCE.get())
                .add(ModFluids.MOLTEN_PIG_IRON_FLOWING.get());
    }
}