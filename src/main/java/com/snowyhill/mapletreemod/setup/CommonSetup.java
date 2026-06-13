package com.snowyhill.mapletreemod.setup;


import com.snowyhill.mapletreemod.registry.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetup {

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
            pot.addPlant(ModBlocks.MAPLE_RED_SAPLING.getId(), ModBlocks.POTTED_MAPLE_RED_SAPLING);
            pot.addPlant(ModBlocks.MAPLE_ORANGE_SAPLING.getId(), ModBlocks.POTTED_MAPLE_ORANGE_SAPLING);
            pot.addPlant(ModBlocks.MAPLE_YELLOW_SAPLING.getId(), ModBlocks.POTTED_MAPLE_YELLOW_SAPLING);
        });
    }
}