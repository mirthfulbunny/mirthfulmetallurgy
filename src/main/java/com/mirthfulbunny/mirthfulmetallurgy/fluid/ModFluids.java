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

    public static final RegistryObject<ForgeFlowingFluid.Source> MOLTEN_WROUGHT_IRON_SOURCE =
            FLUIDS.register("molten_wrought_iron", () -> MoltenWroughtIronFluid.SOURCE);
    public static final RegistryObject<ForgeFlowingFluid.Flowing> MOLTEN_WROUGHT_IRON_FLOWING =
            FLUIDS.register("molten_wrought_iron_flowing", () -> MoltenWroughtIronFluid.FLOWING);

    public static final RegistryObject<ForgeFlowingFluid.Source> MOLTEN_BLISTER_STEEL_SOURCE =
            FLUIDS.register("molten_blister_steel", () -> MoltenBlisterSteelFluid.SOURCE);
    public static final RegistryObject<ForgeFlowingFluid.Flowing> MOLTEN_BLISTER_STEEL_FLOWING =
            FLUIDS.register("molten_blister_steel_flowing", () -> MoltenBlisterSteelFluid.FLOWING);

    public static final RegistryObject<ForgeFlowingFluid.Source> MOLTEN_MILD_STEEL_SOURCE =
            FLUIDS.register("molten_mild_steel", () -> MoltenMildSteelFluid.SOURCE);
    public static final RegistryObject<ForgeFlowingFluid.Flowing> MOLTEN_MILD_STEEL_FLOWING =
            FLUIDS.register("molten_mild_steel_flowing", () -> MoltenMildSteelFluid.FLOWING);

    public static final RegistryObject<ForgeFlowingFluid.Source> MOLTEN_STAINLESS_STEEL_SOURCE =
            FLUIDS.register("molten_stainless_steel", () -> MoltenStainlessSteelFluid.SOURCE);
    public static final RegistryObject<ForgeFlowingFluid.Flowing> MOLTEN_STAINLESS_STEEL_FLOWING =
            FLUIDS.register("molten_stainless_steel_flowing", () -> MoltenStainlessSteelFluid.FLOWING);

    public static final RegistryObject<ForgeFlowingFluid.Source> MOLTEN_MANGANESE_STEEL_SOURCE =
            FLUIDS.register("molten_manganese_steel", () -> MoltenManganeseSteelFluid.SOURCE);
    public static final RegistryObject<ForgeFlowingFluid.Flowing> MOLTEN_MANGANESE_STEEL_FLOWING =
            FLUIDS.register("molten_manganese_steel_flowing", () -> MoltenManganeseSteelFluid.FLOWING);

    public static final RegistryObject<ForgeFlowingFluid.Source> MOLTEN_HIGH_SPEED_STEEL_SOURCE =
            FLUIDS.register("molten_high_speed_steel", () -> MoltenHighSpeedSteelFluid.SOURCE);
    public static final RegistryObject<ForgeFlowingFluid.Flowing> MOLTEN_HIGH_SPEED_STEEL_FLOWING =
            FLUIDS.register("molten_high_speed_steel_flowing", () -> MoltenHighSpeedSteelFluid.FLOWING);

    public static final RegistryObject<ForgeFlowingFluid.Source> MOLTEN_SLAG_SOURCE =
            FLUIDS.register("molten_slag", () -> MoltenSlagFluid.SOURCE);
    public static final RegistryObject<ForgeFlowingFluid.Flowing> MOLTEN_SLAG_FLOWING =
            FLUIDS.register("molten_slag_flowing", () -> MoltenSlagFluid.FLOWING);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
