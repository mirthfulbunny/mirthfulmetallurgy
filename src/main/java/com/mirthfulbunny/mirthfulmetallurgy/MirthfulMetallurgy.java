package com.mirthfulbunny.mirthfulmetallurgy;

import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import com.mirthfulbunny.mirthfulmetallurgy.block.entity.ModBlockEntities;
import com.mirthfulbunny.mirthfulmetallurgy.fluid.ModFluids;
import com.mirthfulbunny.mirthfulmetallurgy.fluid.types.ModFluidTypes;
import com.mirthfulbunny.mirthfulmetallurgy.item.ModCreativeTabs;
import com.mirthfulbunny.mirthfulmetallurgy.item.ModItems;
import com.mirthfulbunny.mirthfulmetallurgy.recipe.ModRecipes;
import com.mirthfulbunny.mirthfulmetallurgy.screen.BloomeryScreen;
import com.mirthfulbunny.mirthfulmetallurgy.screen.HammeringScreen;
import com.mirthfulbunny.mirthfulmetallurgy.screen.ModMenuTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MirthfulMetallurgy.MODID)
public class MirthfulMetallurgy {
    public static final String MODID = "mirthfulmetallurgy";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MirthfulMetallurgy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");

            MenuScreens.register(ModMenuTypes.BLOOMERY_MENU.get(), BloomeryScreen::new);
            MenuScreens.register(ModMenuTypes.HAMMERING_MENU.get(), HammeringScreen::new);

            ItemBlockRenderTypes.setRenderLayer(ModFluids.MOLTEN_PIG_IRON_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.MOLTEN_PIG_IRON_FLOWING.get(), RenderType.translucent());
        }
    }
}
