package com.snowyhill.mapletreemod;

import com.mojang.logging.LogUtils;
import com.snowyhill.mapletreemod.registry.*;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(MapleTreeMod.MOD_ID)
public class MapleTreeMod
{

    public static final String MOD_ID = "mapletreemod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public MapleTreeMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        //アイテムレジストリとイベントバスに登録　ModItemsから情報を得ている。
        ModItems.ITEMS.register(modEventBus);
        //クリエイティブタブをイベントバスに登録
        ModTabs.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        // ブロックレジストリをイベントバスに登録
        ModBlocks.BLOCKS.register(modEventBus);

        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        }



    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

      @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
