package com.snowyhill.mapletreemod.worldgen.features;

import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import static net.minecraft.data.worldgen.features.FeatureUtils.createKey;

public class ModFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_RED_TREE_KEY =
            registerKey("maple_red_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_ORANGE_TREE_KEY =
            registerKey("maple_orange_tree");


    public static void bootstrap(BootstapContext<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> context) {


        FeatureUtils.register(context, MAPLE_RED_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()

                        ),
                        new StraightTrunkPlacer(
                                5, // 基本幹の高さ
                                1, // 一番下の曲がり高さ
                                1  // 分岐数（自然な分岐感）
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_RED_LEAVES.get()),
                        new BlobFoliagePlacer(
                                ConstantInt.of(3), // 半径
                                ConstantInt.of(2), // 高さオフセット
                                4                  // 葉の高さ
                        ),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).ignoreVines().build()
        );

        FeatureUtils.register(context, MAPLE_ORANGE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()

                        ),
                        new StraightTrunkPlacer(
                                5, // 基本幹の高さ
                                1, // 一番下の曲がり高さ
                                1  // 分岐数（自然な分岐感）
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_ORANGE_LEAVES.get()),
                        new BlobFoliagePlacer(
                                ConstantInt.of(3), // 半径
                                ConstantInt.of(2), // 高さオフセット
                                4                  // 葉の高さ
                        ),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).ignoreVines().build()
        );
    }



    public static ResourceKey<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>>
    registerKey(String name) {

        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                new ResourceLocation(
                        MapleTreeMod.MOD_ID,
                        name
                )
        );
    }
}