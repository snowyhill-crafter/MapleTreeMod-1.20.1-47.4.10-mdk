package com.snowyhill.mapletreemod.worldgen.tree;

import com.snowyhill.mapletreemod.worldgen.features.ModFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MapleRedTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        return ModFeatures.MAPLE_RED_TREE_KEY;
    }
}