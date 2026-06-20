package com.snowyhill.mapletreemod.worldgen.features;

import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.worldgen.features.decorator.MapleLeafLitterDecorator;
import com.snowyhill.mapletreemod.worldgen.features.trunkplacers.MapleSapFancyTrunkPlacer;
import com.snowyhill.mapletreemod.worldgen.features.trunkplacers.MapleSapTrunkPlacer;
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
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class ModFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_RED_TREE_KEY =
            registerKey("maple_red_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_ORANGE_TREE_KEY =
            registerKey("maple_orange_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_YELLOW_TREE_KEY =
            registerKey("maple_yellow_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_RED_BIG_TREE_KEY =
            registerKey("maple_red_big_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_ORANGE_BIG_TREE_KEY =
            registerKey("maple_orange_big_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_YELLOW_BIG_TREE_KEY =
            registerKey("maple_yellow_big_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        FeatureUtils.register(context, MAPLE_RED_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                        new MapleSapTrunkPlacer(
                                5,
                                1,
                                2,
                                0.25F
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_RED_LEAVES.get()),
                        new BlobFoliagePlacer(
                                ConstantInt.of(3),
                                ConstantInt.of(0),
                                3
                        ),
                        new TwoLayersFeatureSize(1, 0, 2)
                )
                        .decorators(List.of(
                                new MapleLeafLitterDecorator(ModBlocks.MAPLE_RED_LEAF_LITTER.get())
                        ))
                        .ignoreVines()
                        .build()
        );

        FeatureUtils.register(context, MAPLE_ORANGE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                        new MapleSapTrunkPlacer(
                                5,
                                1,
                                2,
                                0.25F
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_ORANGE_LEAVES.get()),
                        new BlobFoliagePlacer(
                                ConstantInt.of(3),
                                ConstantInt.of(0),
                                3
                        ),
                        new TwoLayersFeatureSize(1, 0, 2)
                )
                        .decorators(List.of(
                                new MapleLeafLitterDecorator(ModBlocks.MAPLE_ORANGE_LEAF_LITTER.get())
                        ))
                        .ignoreVines()
                        .build()
        );

        FeatureUtils.register(context, MAPLE_YELLOW_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                        new MapleSapTrunkPlacer(
                                5,
                                1,
                                2,
                                0.25F
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_YELLOW_LEAVES.get()),
                        new BlobFoliagePlacer(
                                ConstantInt.of(3),
                                ConstantInt.of(0),
                                3
                        ),
                        new TwoLayersFeatureSize(1, 0, 2)
                )
                        .decorators(List.of(
                                new MapleLeafLitterDecorator(ModBlocks.MAPLE_YELLOW_LEAF_LITTER.get())
                        ))
                        .ignoreVines()
                        .build()
        );


        FeatureUtils.register(context, MAPLE_RED_BIG_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                        new MapleSapFancyTrunkPlacer(
                                3,
                                11,
                                0,
                                0.25F
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_RED_LEAVES.get()),
                        new FancyFoliagePlacer(
                                ConstantInt.of(2),
                                ConstantInt.of(4),
                                4
                        ),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
                )
                        .decorators(List.of(
                                new MapleLeafLitterDecorator(ModBlocks.MAPLE_RED_LEAF_LITTER.get())
                        ))
                        .ignoreVines()
                        .build()
        );

        FeatureUtils.register(context, MAPLE_ORANGE_BIG_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                        new MapleSapFancyTrunkPlacer(
                                3,
                                11,
                                0,
                                0.25F
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_ORANGE_LEAVES.get()),
                        new FancyFoliagePlacer(
                                ConstantInt.of(2),
                                ConstantInt.of(4),
                                4
                        ),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
                )
                        .decorators(List.of(
                                new MapleLeafLitterDecorator(ModBlocks.MAPLE_ORANGE_LEAF_LITTER.get())
                        ))
                        .ignoreVines()
                        .build()
        );

        FeatureUtils.register(context, MAPLE_YELLOW_BIG_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                        new MapleSapFancyTrunkPlacer(
                                3,
                                11,
                                0,
                                0.25F
                        ),
                        BlockStateProvider.simple(ModBlocks.MAPLE_YELLOW_LEAVES.get()),
                        new FancyFoliagePlacer(
                                ConstantInt.of(2),
                                ConstantInt.of(4),
                                4
                        ),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
                )
                        .decorators(List.of(
                                new MapleLeafLitterDecorator(ModBlocks.MAPLE_YELLOW_LEAF_LITTER.get())
                        ))
                        .ignoreVines()
                        .build()
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                new ResourceLocation(MapleTreeMod.MOD_ID, name)
        );
    }
}