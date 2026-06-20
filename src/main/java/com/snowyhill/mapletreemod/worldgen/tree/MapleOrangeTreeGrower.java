package com.snowyhill.mapletreemod.worldgen.tree;

import com.snowyhill.mapletreemod.worldgen.features.ModFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MapleOrangeTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        if (random.nextFloat() < 0.10F) {
            return ModFeatures.MAPLE_ORANGE_BIG_TREE_KEY;
        }
        return ModFeatures.MAPLE_ORANGE_TREE_KEY;
    }
}