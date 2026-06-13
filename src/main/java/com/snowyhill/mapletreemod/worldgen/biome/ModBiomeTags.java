package com.snowyhill.mapletreemod.worldgen.biome;


import com.snowyhill.mapletreemod.MapleTreeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTags {

    //
    // public static final TagKey<Biome> MAPLE_RED_TREE_SPAWNABLE = create("maple_red_tree_spawnable");
    //public static final TagKey<Biome> MAPLE_ORANGE_TREE_SPAWNABLE = create("maple_orange_tree_spawnable");
    //public static final TagKey<Biome> MAPLE_YELLOW_TREE_SPAWNABLE = create("maple_yellow_tree_spawnable");

    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(MapleTreeMod.MOD_ID, name));
    }
}