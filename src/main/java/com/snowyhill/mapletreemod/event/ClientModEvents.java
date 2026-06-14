package com.snowyhill.mapletreemod.event;

import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.particle.MapleLeafParticle;
import com.snowyhill.mapletreemod.particle.ModParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.snowyhill.mapletreemod.registry.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(
        modid = MapleTreeMod.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(
                ModParticleTypes.MAPLE_RED_LEAF.get(),
                MapleLeafParticle.Provider::new
        );

        event.registerSpriteSet(
                ModParticleTypes.MAPLE_ORANGE_LEAF.get(),
                MapleLeafParticle.Provider::new
        );

        event.registerSpriteSet(
                ModParticleTypes.MAPLE_YELLOW_LEAF.get(),
                MapleLeafParticle.Provider::new
        );
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
//テクスチャの透明を使ったモデルに必要な処置
            ItemBlockRenderTypes.setRenderLayer(
                    ModBlocks.MAPLE_RED_LEAF_LITTER.get(),
                    RenderType.cutout()
            );

            ItemBlockRenderTypes.setRenderLayer(
                    ModBlocks.MAPLE_ORANGE_LEAF_LITTER.get(),
                    RenderType.cutout()
            );

            ItemBlockRenderTypes.setRenderLayer(
                    ModBlocks.MAPLE_YELLOW_LEAF_LITTER.get(),
                    RenderType.cutout()
            );

            ItemBlockRenderTypes.setRenderLayer(
                    ModBlocks.SAP_COLLECTOR.get(),
                    RenderType.translucent() //半透明を指定
            );

        });
    }

}