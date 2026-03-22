package com.mirthfulbunny.mirthfulmetallurgy.item;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MirthfulMetallurgy.MODID);

    // Ingots
    public static final RegistryObject<Item> WROUGHT_IRON_INGOT = ITEMS.register("wrought_iron_ingot",
            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> PIG_IRON_INGOT = ITEMS.register("pig_iron_ingot",
//            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLISTER_STEEL_INGOT = ITEMS.register("blister_steel_ingot",
            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> MILD_STEEL_INGOT = ITEMS.register("mild_steel_ingot",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> STAINLESS_STEEL_INGOT = ITEMS.register("stainless_steel_ingot",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> MANGANESE_STEEL_INGOT = ITEMS.register("manganese_steel_ingot",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> HIGH_SPEED_STEEL_INGOT = ITEMS.register("high_speed_steel_ingot",
//            () -> new Item(new Item.Properties()));

    // Artisan Era
    public static final RegistryObject<Item> FIRE_CLAY = ITEMS.register("fire_clay", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_CLAY_BRICK = ITEMS.register("fire_clay_brick", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLOOM = ITEMS.register("bloom",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHARCOAL_DUST = ITEMS.register("charcoal_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SLAG = ITEMS.register("slag", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PRECARBURIZED_WROUGHT_IRON_INGOT = ITEMS.register("precarburized_wrought_iron_ingot",
            () -> new Item(new Item.Properties()));

//    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
//            () -> new ModHammer(Tiers.IRON, new Item.Properties().durability(255)));

    public static final RegistryObject<Item> WROUGHT_IRON_SWORD = ITEMS.register("wrought_iron_sword",
            () -> new SwordItem(ModToolTiers.WROUGHT_IRON, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> WROUGHT_IRON_PICKAXE = ITEMS.register("wrought_iron_pickaxe",
            () -> new PickaxeItem(ModToolTiers.WROUGHT_IRON, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> WROUGHT_IRON_AXE = ITEMS.register("wrought_iron_axe",
            () -> new AxeItem(ModToolTiers.WROUGHT_IRON, 6, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> WROUGHT_IRON_SHOVEL = ITEMS.register("wrought_iron_shovel",
            () -> new ShovelItem(ModToolTiers.WROUGHT_IRON, 1, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> WROUGHT_IRON_HOE = ITEMS.register("wrought_iron_hoe",
            () -> new HoeItem(ModToolTiers.WROUGHT_IRON, -2, -1, new Item.Properties()));

    public static final RegistryObject<Item> BLISTER_STEEL_SWORD = ITEMS.register("blister_steel_sword",
            () -> new SwordItem(ModToolTiers.BLISTER_STEEL, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> BLISTER_STEEL_PICKAXE = ITEMS.register("blister_steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BLISTER_STEEL, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> BLISTER_STEEL_AXE = ITEMS.register("blister_steel_axe",
            () -> new AxeItem(ModToolTiers.BLISTER_STEEL, 6, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> BLISTER_STEEL_SHOVEL = ITEMS.register("blister_steel_shovel",
            () -> new ShovelItem(ModToolTiers.BLISTER_STEEL, 1, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> BLISTER_STEEL_HOE = ITEMS.register("blister_steel_hoe",
            () -> new HoeItem(ModToolTiers.BLISTER_STEEL, -2, -1, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
