package com.mirthfulbunny.mirthfulmetallurgy.item;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
