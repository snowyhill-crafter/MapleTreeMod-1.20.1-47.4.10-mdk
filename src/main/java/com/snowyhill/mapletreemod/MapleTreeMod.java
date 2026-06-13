package com.snowyhill.mapletreemod;

import com.mojang.logging.LogUtils;
import com.snowyhill.mapletreemod.particle.ModParticleTypes;
import com.snowyhill.mapletreemod.registry.*;

import com.snowyhill.mapletreemod.worldgen.biome.ModOverworldRegion;
import com.snowyhill.mapletreemod.worldgen.biome.ModSurfaceRuleData;
import com.snowyhill.mapletreemod.worldgen.features.decorator.ModTreeDecorators;
import net.minecraft.resources.ResourceLocation;
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
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;


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

        ModParticleTypes.PARTICLES.register(modEventBus);

        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModTreeDecorators.TREE_DECORATORS.register(modEventBus);
        }



    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            Regions.register(new ModOverworldRegion(
                    new ResourceLocation(MapleTreeMod.MOD_ID, "overworld"),5
            ));
         //   SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,
         //           MOD_ID, ModSurfaceRuleData.makeRules());
        });
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
