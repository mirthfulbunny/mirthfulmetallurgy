package com.mirthfulbunny.mirthfulmetallurgy.fluid;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, MirthfulMetallurgy.MODID);

    public static final RegistryObject<ForgeFlowingFluid.Source> MOLTEN_PIG_IRON_SOURCE =
            FLUIDS.register("molten_pig_iron", () -> MoltenPigIronFluid.SOURCE);

    public static final RegistryObject<ForgeFlowingFluid.Flowing> MOLTEN_PIG_IRON_FLOWING =
            FLUIDS.register("molten_pig_iron_flowing", () -> MoltenPigIronFluid.FLOWING);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
