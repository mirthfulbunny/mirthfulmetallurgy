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

    public static final RegistryObject<FluidType> MOLTEN_WROUGHT_IRON_TYPE = FLUID_TYPES.register("molten_wrought_iron",
            MoltenWroughtIronFluidType::new);

    public static final RegistryObject<FluidType> MOLTEN_PIG_IRON_TYPE = FLUID_TYPES.register("molten_pig_iron",
            MoltenPigIronFluidType::new);

    public static final RegistryObject<FluidType> MOLTEN_BLISTER_STEEL_TYPE = FLUID_TYPES.register("molten_blister_steel",
            MoltenBlisterSteelFluidType::new);

    public static final RegistryObject<FluidType> MOLTEN_MILD_STEEL_TYPE = FLUID_TYPES.register("molten_mild_steel",
            MoltenMildSteelFluidType::new);

    public static final RegistryObject<FluidType> MOLTEN_HIGH_SPEED_STEEL_TYPE = FLUID_TYPES.register("molten_high_speed_steel",
            MoltenHighSpeedSteelFluidType::new);

    public static final RegistryObject<FluidType> MOLTEN_STAINLESS_STEEL_TYPE = FLUID_TYPES.register("molten_stainless_steel",
            MoltenStainlessSteelFluidType::new);

    public static final RegistryObject<FluidType> MOLTEN_MANGANESE_STEEL_TYPE = FLUID_TYPES.register("molten_manganese_steel",
            MoltenManganeseSteelFluidType::new);

    public static final RegistryObject<FluidType> MOLTEN_SLAG_TYPE = FLUID_TYPES.register("molten_slag",
            MoltenSlagFluidType::new);

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
