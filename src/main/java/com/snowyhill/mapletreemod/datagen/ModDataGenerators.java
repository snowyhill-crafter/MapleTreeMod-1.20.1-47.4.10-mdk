package com.snowyhill.mapletreemod.datagen;




import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.datagen.client.ENUSLanguageProvider;
import com.snowyhill.mapletreemod.datagen.client.JAJPLanguageProvider;
import com.snowyhill.mapletreemod.datagen.client.ModBlockStateProvider;
import com.snowyhill.mapletreemod.datagen.client.ModItemModelProvider;
import com.snowyhill.mapletreemod.datagen.server.*;
import com.snowyhill.mapletreemod.datagen.server.loot.ModLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MapleTreeMod.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD )
public class ModDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        //ItemModel
        generator.addProvider(event.includeClient(), new ModItemModelProvider(
                packOutput , existingFileHelper));
        //blockstate
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(
                packOutput , existingFileHelper));
        // 言語ファイル
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        //worldgen
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(
                packOutput , lookUpProvider));

        // biome tags
        generator.addProvider(event.includeServer(), new ModBiomeTagsProvider(
                packOutput, lookUpProvider, existingFileHelper));

        //ブロックタグ
        var blockTagsProvider = generator.addProvider(event.includeServer(),
                new ModBlockTagsProvider(packOutput
                        ,lookUpProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModItemTagsProvider(
                packOutput, lookUpProvider, blockTagsProvider.contentsGetter(),
                MapleTreeMod.MOD_ID , existingFileHelper));




        // レシピ
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
       //ルートテーブル
        generator.addProvider(event.includeServer(),  ModLootTables.create(packOutput, lookUpProvider));

        // GlobalLootModifier
        generator.addProvider(event.includeServer(),
                new ModGlobalLootModifierProvider(packOutput));





    }
}
