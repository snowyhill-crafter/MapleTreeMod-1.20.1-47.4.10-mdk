package com.snowyhill.mapletreemod.datagen.server;



import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.worldgen.biome.ModBiomeModifiers;
import com.snowyhill.mapletreemod.worldgen.features.ModFeatures;
import com.snowyhill.mapletreemod.worldgen.placement.ModPlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacement::bootstap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MapleTreeMod.MOD_ID));
    }
}