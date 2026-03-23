package com.mirthfulbunny.mirthfulmetallurgy.item;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MirthfulMetallurgy.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLISTER_STEEL_INGOT.get()))
                    .title(Component.translatable("itemGroup.mirthful_metallurgy"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WROUGHT_IRON_INGOT.get());
                        pOutput.accept(ModItems.PIG_IRON_INGOT.get());
                        pOutput.accept(ModItems.BLISTER_STEEL_INGOT.get());
                        pOutput.accept(ModItems.MILD_STEEL_INGOT.get());
                        pOutput.accept(ModItems.STAINLESS_STEEL_INGOT.get());
                        pOutput.accept(ModItems.MANGANESE_STEEL_INGOT.get());
                        pOutput.accept(ModItems.HIGH_SPEED_STEEL_INGOT.get());

                        pOutput.accept(ModBlocks.WROUGHT_IRON_BLOCK.get());
                        pOutput.accept(ModBlocks.PIG_IRON_BLOCK.get());
                        pOutput.accept(ModBlocks.BLISTER_STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.MILD_STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.STAINLESS_STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.MANGANESE_STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.HIGH_SPEED_STEEL_BLOCK.get());

                        pOutput.accept(ModItems.MOLTEN_PIG_IRON_BUCKET.get());

                        pOutput.accept(ModBlocks.BLOOMERY.get());
                        pOutput.accept(ModBlocks.HAMMER_TABLE.get());

                        pOutput.accept(ModItems.FIRE_CLAY.get());
                        pOutput.accept(ModItems.FIRE_CLAY_BRICK.get());
                        pOutput.accept(ModItems.BLOOM.get());
                        pOutput.accept(ModItems.CHARCOAL_DUST.get());
                        pOutput.accept(ModItems.SLAG.get());
                        pOutput.accept(ModItems.PRECARBURIZED_WROUGHT_IRON_INGOT.get());

                        pOutput.accept(ModItems.WROUGHT_IRON_AXE.get());
                        pOutput.accept(ModItems.WROUGHT_IRON_PICKAXE.get());
                        pOutput.accept(ModItems.WROUGHT_IRON_SWORD.get());
                        pOutput.accept(ModItems.WROUGHT_IRON_SHOVEL.get());
                        pOutput.accept(ModItems.WROUGHT_IRON_HOE.get());

                        pOutput.accept(ModItems.BLISTER_STEEL_AXE.get());
                        pOutput.accept(ModItems.BLISTER_STEEL_PICKAXE.get());
                        pOutput.accept(ModItems.BLISTER_STEEL_SWORD.get());
                        pOutput.accept(ModItems.BLISTER_STEEL_SHOVEL.get());
                        pOutput.accept(ModItems.BLISTER_STEEL_HOE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
