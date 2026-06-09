package com.snowyhill.mapletreemod.client;


import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.client.renderer.ModBoatRenderer;
import com.snowyhill.mapletreemod.registry.ModBlockEntities;
import com.snowyhill.mapletreemod.registry.ModEntities;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        modid = MapleTreeMod.MOD_ID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public final class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {


        Sheets.addWoodType(ModWoodTypes.MAPLE);
               /* ========= 看板レンダラー登録（★これが必須） ========= */
        BlockEntityRenderers.register(
                ModBlockEntities.SIGN.get(),
                SignRenderer::new
        );

        BlockEntityRenderers.register(
                ModBlockEntities.HANGING_SIGN.get(),
                HangingSignRenderer::new
        );


        /* ========= ボートレンダラー登録 ========= */
// エンティティレンダラーの登録は EntityRenderers.register を使用します
        EntityRenderers.register(ModEntities.MOD_BOAT.get(), context -> new ModBoatRenderer(context, false));
        EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), context -> new ModBoatRenderer(context, true));

    }

    private ClientSetup() {}
}
