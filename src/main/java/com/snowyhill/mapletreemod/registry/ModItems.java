package com.snowyhill.mapletreemod.registry;


import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.entity.ModBoatEntity;

import com.snowyhill.mapletreemod.item.ModBoatItem;
import com.snowyhill.mapletreemod.item.SapCollectorItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    // レジストリの作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MapleTreeMod.MOD_ID);

    // レジストリにアイテムを追加

    public static final RegistryObject<Item> MAPLE_RED_SAPLING_ITEM = ITEMS.register("maple_red_sapling",
            () -> new BlockItem(ModBlocks.MAPLE_RED_SAPLING.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_ORANGE_SAPLING_ITEM = ITEMS.register("maple_orange_sapling",
            () -> new BlockItem(ModBlocks.MAPLE_ORANGE_SAPLING.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_YELLOW_SAPLING_ITEM = ITEMS.register("maple_yellow_sapling",
            () -> new BlockItem(ModBlocks.MAPLE_YELLOW_SAPLING.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_LOG_ITEM = ITEMS.register(
            "maple_log",
            () -> new BlockItem(ModBlocks.MAPLE_LOG.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_SAP_LOG_ITEM = ITEMS.register(
            "maple_sap_log",
            () -> new BlockItem(ModBlocks.MAPLE_SAP_LOG.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG_ITEM = ITEMS.register(
            "stripped_maple_log",
            () -> new BlockItem(ModBlocks.STRIPPED_MAPLE_LOG.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_WOOD_ITEM = ITEMS.register(
            "maple_wood",
            () -> new BlockItem(ModBlocks.MAPLE_WOOD.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD_ITEM = ITEMS.register(
            "stripped_maple_wood",
            () -> new BlockItem(ModBlocks.STRIPPED_MAPLE_WOOD.get(), new Item.Properties())
    );




    public static final RegistryObject<Item> MAPLE_PLANKS_ITEM = ITEMS.register(
            "maple_planks",
            () -> new BlockItem(ModBlocks.MAPLE_PLANKS.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_SLAB_ITEM = ITEMS.register(
            "maple_slab",
            () -> new BlockItem(ModBlocks.MAPLE_SLAB.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_STAIRS_ITEM = ITEMS.register(
            "maple_stairs",
            () -> new BlockItem(ModBlocks.MAPLE_STAIRS.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_FENCE_ITEM = ITEMS.register(
            "maple_fence",
            () -> new BlockItem(ModBlocks.MAPLE_FENCE.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_FENCE_GATE_ITEM = ITEMS.register(
            "maple_fence_gate",
            () -> new BlockItem(ModBlocks.MAPLE_FENCE_GATE.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_DOOR_ITEM = ITEMS.register(
            "maple_door",
            () -> new BlockItem(ModBlocks.MAPLE_DOOR.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_TRAPDOOR_ITEM = ITEMS.register(
            "maple_trapdoor",
            () -> new BlockItem(ModBlocks.MAPLE_TRAPDOOR.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_BUTTON_ITEM = ITEMS.register(
            "maple_button",
            () -> new BlockItem(ModBlocks.MAPLE_BUTTON.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_PRESSURE_PLATE_ITEM = ITEMS.register(
            "maple_pressure_plate",
            () -> new BlockItem(ModBlocks.MAPLE_PRESSURE_PLATE.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_SIGN_ITEM = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    ModBlocks.MAPLE_SIGN.get(), ModBlocks.MAPLE_WALL_SIGN.get()));

    public static final RegistryObject<Item> MAPLE_HANGING_SIGN_ITEM = ITEMS.register("maple_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));



    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.MAPLE, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = ITEMS.register("maple_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.MAPLE, new Item.Properties().stacksTo(1)));

      public static final RegistryObject<Item> MAPLE_RED_LEAVES_ITEM = ITEMS.register(
            "maple_red_leaves",
            () -> new BlockItem(ModBlocks.MAPLE_RED_LEAVES.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_ORANGE_LEAVES_ITEM = ITEMS.register(
            "maple_orange_leaves",
            () -> new BlockItem(ModBlocks.MAPLE_ORANGE_LEAVES.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_YELLOW_LEAVES_ITEM = ITEMS.register(
            "maple_yellow_leaves",
            () -> new BlockItem(ModBlocks.MAPLE_YELLOW_LEAVES.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_RED_LEAF_LITTER =
            ITEMS.register("maple_red_leaf_litter",
                    () -> new BlockItem(ModBlocks.MAPLE_RED_LEAF_LITTER.get(),
                            new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_ORANGE_LEAF_LITTER =
            ITEMS.register("maple_orange_leaf_litter",
                    () -> new BlockItem(ModBlocks.MAPLE_ORANGE_LEAF_LITTER.get(),
                            new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_YELLOW_LEAF_LITTER =
            ITEMS.register("maple_yellow_leaf_litter",
                    () -> new BlockItem(ModBlocks.MAPLE_YELLOW_LEAF_LITTER.get(),
                            new Item.Properties()));

    public static final RegistryObject<Item> SAP_COLLECTOR_ITEM = ITEMS.register(
            "sap_collector",
            () -> new SapCollectorItem(ModBlocks.SAP_COLLECTOR.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MAPLE_SAP_BOTTLE = ITEMS.register(
            "maple_sap_bottle",
            () -> new Item(new Item.Properties()
                    .craftRemainder(Items.GLASS_BOTTLE)//クラフト後にボトルが残る
                    .stacksTo(16)
            )
    );

    public static final RegistryObject<Item> MAPLE_SYRUP_BOTTLE = ITEMS.register(
            "maple_syrup_bottle",
            () -> new Item(new Item.Properties()
                    .craftRemainder(Items.GLASS_BOTTLE)//クラフト後にボトルが残る
                    .stacksTo(16)
            )
    );

    public static final RegistryObject<Item> MAPLE_TAFFY = ITEMS.register(
            "maple_taffy",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(2)          // 満腹度 +2（肉1個分）
                            .saturationMod(0.2F)   // 隠し満腹度
                            .fast()                // お菓子なので即食べられる
                            .build())
            )
    );

    public static final RegistryObject<Item> MAPLE_PANCAKE_ITEM = ITEMS.register("maple_pancake",
            () -> new BlockItem(ModBlocks.MAPLE_PANCAKE.get(), new Item.Properties()
                    .stacksTo(1)
            ));


    public static void register(IEventBus eventBus) {
        // レジストリをイベントバスに登録
        ITEMS.register(eventBus);
    }
}