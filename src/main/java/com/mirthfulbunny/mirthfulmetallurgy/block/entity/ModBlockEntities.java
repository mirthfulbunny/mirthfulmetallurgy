package com.mirthfulbunny.mirthfulmetallurgy.block.entity;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MirthfulMetallurgy.MODID);

    public static final RegistryObject<BlockEntityType<BloomeryBlockEntity>> BLOOMERY_BE =
            BLOCK_ENTITIES.register("bloomery_be", () ->
                    BlockEntityType.Builder.of(BloomeryBlockEntity::new,
                            ModBlocks.BLOOMERY.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
