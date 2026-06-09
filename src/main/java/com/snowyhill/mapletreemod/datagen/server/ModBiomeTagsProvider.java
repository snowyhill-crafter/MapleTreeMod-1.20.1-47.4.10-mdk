package com.snowyhill.mapletreemod.datagen.server;

import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.worldgen.biome.ModBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsProvider extends BiomeTagsProvider {

    public ModBiomeTagsProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> lookupProvider,
                                ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MapleTreeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModBiomeTags.
                MAPLE_RED_TREE_SPAWNABLE)
                .add(Biomes.FOREST);


        tag(ModBiomeTags.
                MAPLE_ORANGE_TREE_SPAWNABLE)
                .add(Biomes.FOREST);
    }

}