package com.mirthfulbunny.mirthfulmetallurgy.fluid.types;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MirthfulMetallurgy.MODID);

    public static final RegistryObject<FluidType> MOLTEN_PIG_IRON_TYPE = FLUID_TYPES.register("molten_pig_iron",
            MoltenPigIronFluidType::new);

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
