package com.mirthfulbunny.mirthfulmetallurgy.datagen;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import com.mirthfulbunny.mirthfulmetallurgy.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MirthfulMetallurgy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.BLOOMERY.get(),
                ModBlocks.HAMMER_TABLE.get()
        );
    }
}
