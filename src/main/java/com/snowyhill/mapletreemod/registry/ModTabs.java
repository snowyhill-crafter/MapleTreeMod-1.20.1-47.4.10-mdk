package com.snowyhill.mapletreemod.registry;


import com.snowyhill.mapletreemod.MapleTreeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModTabs {
    //レジストリを作る
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MapleTreeMod.MOD_ID);

    //レジストリにタブを追加
    public static final RegistryObject<CreativeModeTab> MAPLETREEMOD_TAB = TABS.register("mapletreemmod_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.Mod_tab"))
                    .icon(ModItems.MAPLE_RED_SAPLING_ITEM.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.MAPLE_RED_SAPLING_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_ORANGE_SAPLING_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_YELLOW_SAPLING_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_LOG_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_SAP_LOG_ITEM.get());
                        pOutput.accept(ModItems.STRIPPED_MAPLE_LOG_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_WOOD_ITEM.get());
                        pOutput.accept(ModItems.STRIPPED_MAPLE_WOOD_ITEM.get());


                        pOutput.accept(ModItems.MAPLE_PLANKS_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_SLAB_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_STAIRS_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_FENCE_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_FENCE_GATE_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_DOOR_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_TRAPDOOR_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_BUTTON_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_PRESSURE_PLATE_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_SIGN_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_HANGING_SIGN_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_BOAT.get());
                        pOutput.accept(ModItems.MAPLE_CHEST_BOAT.get());
                        pOutput.accept(ModItems.MAPLE_RED_LEAVES_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_ORANGE_LEAVES_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_YELLOW_LEAVES_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_RED_LEAF_LITTER.get());
                        pOutput.accept(ModItems.MAPLE_ORANGE_LEAF_LITTER.get());
                        pOutput.accept(ModItems.MAPLE_YELLOW_LEAF_LITTER.get());

                        pOutput.accept(ModItems.SAP_COLLECTOR_ITEM.get());
                        pOutput.accept(ModItems.MAPLE_SAP_BOTTLE.get());
                        pOutput.accept(ModItems.MAPLE_SYRUP_BOTTLE.get());
                        pOutput.accept(ModItems.MAPLE_TAFFY.get());
                        pOutput.accept(ModItems.MAPLE_PANCAKE_ITEM.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
