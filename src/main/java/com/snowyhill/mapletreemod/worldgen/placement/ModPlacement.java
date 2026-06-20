package com.snowyhill.mapletreemod.worldgen.placement;


import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.worldgen.features.ModFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.snowyhill.mapletreemod.worldgen.features.ModFeatures.registerKey;
import static net.minecraft.data.worldgen.placement.PlacementUtils.createKey;

public class ModPlacement {

    public static final ResourceKey<PlacedFeature> MAPLE_RED_TREE =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    new ResourceLocation(MapleTreeMod.MOD_ID, "maple_red_tree")
            );

    public static final ResourceKey<PlacedFeature> MAPLE_ORANGE_TREE =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    new ResourceLocation(MapleTreeMod.MOD_ID, "maple_orange_tree")
            );

    public static final ResourceKey<PlacedFeature> MAPLE_YELLOW_TREE =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    new ResourceLocation(MapleTreeMod.MOD_ID, "maple_yellow_tree")
            );

    public static final ResourceKey<PlacedFeature> MAPLE_RED_BIG_TREE =
            registerPlacedKey("maple_red_big_tree");

    public static final ResourceKey<PlacedFeature> MAPLE_ORANGE_BIG_TREE =
            registerPlacedKey("maple_orange_big_tree");

    public static final ResourceKey<PlacedFeature> MAPLE_YELLOW_BIG_TREE =
            registerPlacedKey("maple_yellow_big_tree");



    public static final ResourceKey<PlacedFeature> MAPLE_FOREST_OAK_TREE =
            registerPlacedKey("maple_forest_oak_tree");

    public static final ResourceKey<PlacedFeature> MAPLE_FOREST_FANCY_OAK_TREE =
            registerPlacedKey("maple_forest_fancy_oak_tree");


    public static final ResourceKey<PlacedFeature> MAPLE_FOREST_BROWN_MUSHROOM =
            registerPlacedKey("maple_forest_brown_mushroom");

    public static final ResourceKey<PlacedFeature> MAPLE_FOREST_RED_MUSHROOM =
            registerPlacedKey("maple_forest_red_mushroom");


    public static void bootstap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);


        PlacementUtils.register(context, MAPLE_RED_TREE,
                configuredFeatures.getOrThrow(ModFeatures.MAPLE_RED_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.2f, 1),
                        //1チャンク当たりの本数、追加の確率、追加されるときの本数
                        ModBlocks.MAPLE_RED_SAPLING.get()));

        PlacementUtils.register(context, MAPLE_ORANGE_TREE,
                configuredFeatures.getOrThrow(ModFeatures.MAPLE_ORANGE_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.2f, 1),
                        //1チャンク当たりの本数、追加の確率、追加されるときの本数
                        ModBlocks.MAPLE_ORANGE_SAPLING.get()));

        PlacementUtils.register(context, MAPLE_YELLOW_TREE,
                configuredFeatures.getOrThrow(ModFeatures.MAPLE_YELLOW_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.2f, 1),
                        //1チャンク当たりの本数、追加の確率、追加されるときの本数
                        ModBlocks.MAPLE_YELLOW_SAPLING.get()));

        PlacementUtils.register(context, MAPLE_RED_BIG_TREE,
                configuredFeatures.getOrThrow(ModFeatures.MAPLE_RED_BIG_TREE_KEY),
                VegetationPlacements.treePlacement(
                        RarityFilter.onAverageOnceEvery(8),
                        ModBlocks.MAPLE_RED_SAPLING.get()
                )
        );

        PlacementUtils.register(context, MAPLE_ORANGE_BIG_TREE,
                configuredFeatures.getOrThrow(ModFeatures.MAPLE_ORANGE_BIG_TREE_KEY),
                VegetationPlacements.treePlacement(
                        RarityFilter.onAverageOnceEvery(8),
                        ModBlocks.MAPLE_ORANGE_SAPLING.get()
                )
        );

        PlacementUtils.register(context, MAPLE_YELLOW_BIG_TREE,
                configuredFeatures.getOrThrow(ModFeatures.MAPLE_YELLOW_BIG_TREE_KEY),
                VegetationPlacements.treePlacement(
                        RarityFilter.onAverageOnceEvery(8),
                        ModBlocks.MAPLE_YELLOW_SAPLING.get()
                )
        );




        PlacementUtils.register(
                context,
                MAPLE_FOREST_OAK_TREE,
                configuredFeatures.getOrThrow(TreeFeatures.OAK),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.1f, 1),
                        Blocks.OAK_SAPLING
                )
        );

        PlacementUtils.register(
                context,
                MAPLE_FOREST_FANCY_OAK_TREE,
                configuredFeatures.getOrThrow(TreeFeatures.FANCY_OAK),
                VegetationPlacements.treePlacement(
                        RarityFilter.onAverageOnceEvery(10),
                        Blocks.OAK_SAPLING
                )
        );



        PlacementUtils.register(
                context,
                MAPLE_FOREST_BROWN_MUSHROOM,
                configuredFeatures.getOrThrow(VegetationFeatures.PATCH_BROWN_MUSHROOM),
                RarityFilter.onAverageOnceEvery(6),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );

        PlacementUtils.register(
                context,
                MAPLE_FOREST_RED_MUSHROOM,
                configuredFeatures.getOrThrow(VegetationFeatures.PATCH_RED_MUSHROOM),
                RarityFilter.onAverageOnceEvery(8),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );



    }


    //githubからこぴぺ


    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }

    private static ResourceKey<PlacedFeature> registerPlacedKey(String name) {
        return ResourceKey.create(
                Registries.PLACED_FEATURE,
                new ResourceLocation(MapleTreeMod.MOD_ID, name)
        );
    }

}
