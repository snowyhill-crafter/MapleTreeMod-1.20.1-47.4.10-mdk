package com.snowyhill.mapletreemod.worldgen.features;

import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;

import com.snowyhill.mapletreemod.worldgen.features.decorator.MapleLeafLitterDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

import static net.minecraft.data.worldgen.features.FeatureUtils.createKey;

public class ModFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_RED_TREE_KEY =
            registerKey("maple_red_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_ORANGE_TREE_KEY =
            registerKey("maple_orange_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_YELLOW_TREE_KEY =
            registerKey("maple_yellow_tree");

    public static void bootstrap(BootstapContext<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> context) {


        FeatureUtils.register(context, MAPLE_RED_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.MAPLE_LOG.get().defaultBlockState(), 7)    // 大半をこっち
                                .add(ModBlocks.MAPLE_SAP_LOG.get().defaultBlockState(), 1) // 1割くらい（調整可）
                        ),
                        new StraightTrunkPlacer(
                                5, // 基本幹の高さ
                                1, //
                                2  //
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_RED_LEAVES.get()),
                        new BlobFoliagePlacer(
                                ConstantInt.of(3), // 半径
                                ConstantInt.of(0), // 高さオフセット
                                3                  // 葉の下部の大きさ
                        ),
                        new TwoLayersFeatureSize(1, 0, 2))
                        .decorators(List.of(
                                new MapleLeafLitterDecorator(ModBlocks.MAPLE_RED_LEAF_LITTER.get())
                        ))
                        .ignoreVines().build()
        );

        FeatureUtils.register(context, MAPLE_ORANGE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.MAPLE_LOG.get().defaultBlockState(), 7)    // 大半をこっち
                                .add(ModBlocks.MAPLE_SAP_LOG.get().defaultBlockState(), 1) // 1割くらい（調整可）
                        ),
                        new StraightTrunkPlacer(
                                5, // 基本幹の高さ
                                1, //
                                2  //
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_ORANGE_LEAVES.get()),
                        new BlobFoliagePlacer(
                                ConstantInt.of(3), // 半径
                                ConstantInt.of(0), // 高さオフセット
                                3                  // 葉の下部の大きさ
                        ),
                        new TwoLayersFeatureSize(1, 0, 2))
                .decorators(List.of(
                new MapleLeafLitterDecorator(ModBlocks.MAPLE_ORANGE_LEAF_LITTER.get())
                ))
                .ignoreVines().build()
        );

        FeatureUtils.register(context, MAPLE_YELLOW_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.MAPLE_LOG.get().defaultBlockState(), 7)    // 大半をこっち
                                .add(ModBlocks.MAPLE_SAP_LOG.get().defaultBlockState(), 1) // 1割くらい（調整可）

                        ),
                        new StraightTrunkPlacer(
                                5, // 基本幹の高さ
                                1, //
                                2  //
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_YELLOW_LEAVES.get()),
                        new BlobFoliagePlacer(
                                ConstantInt.of(3), // 半径
                                ConstantInt.of(0), // 高さオフセット
                                3                  // 葉の下部の大きさ
                        ),
                        new TwoLayersFeatureSize(1, 0, 2)
                )
                        .decorators(List.of(
                                new MapleLeafLitterDecorator(ModBlocks.MAPLE_YELLOW_LEAF_LITTER.get())
                                ))
                        .ignoreVines()
                                        .build()
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