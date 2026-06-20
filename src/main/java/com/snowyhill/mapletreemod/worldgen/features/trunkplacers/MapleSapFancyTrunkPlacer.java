
package com.snowyhill.mapletreemod.worldgen.features.trunkplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class MapleSapFancyTrunkPlacer extends FancyTrunkPlacer {

    public static final Codec<MapleSapFancyTrunkPlacer> CODEC =
            RecordCodecBuilder.create(instance ->
                    trunkPlacerParts(instance)
                            .and(Codec.FLOAT.fieldOf("sap_chance").forGetter(p -> p.sapChance))
                            .apply(instance, MapleSapFancyTrunkPlacer::new)
            );

    private final float sapChance;

    public MapleSapFancyTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, float sapChance) {
        super(baseHeight, heightRandA, heightRandB);
        this.sapChance = sapChance;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.MAPLE_SAP_FANCY_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(
            LevelSimulatedReader level,
            BiConsumer<BlockPos, BlockState> blockSetter,
            RandomSource random,
            int freeTreeHeight,
            BlockPos pos,
            TreeConfiguration config
    ) {
        BiConsumer<BlockPos, BlockState> sapReplacingSetter = (placePos, state) -> {
            BlockState finalState = state;

            boolean isVerticalLog =
                    state.hasProperty(RotatedPillarBlock.AXIS)
                            && state.getValue(RotatedPillarBlock.AXIS) == net.minecraft.core.Direction.Axis.Y;

            boolean isNotBottom = placePos.getY() > pos.getY();

            if (isVerticalLog && isNotBottom && random.nextFloat() < this.sapChance) {
                BlockState sapState = ModBlocks.MAPLE_SAP_LOG.get().defaultBlockState();

                if (sapState.hasProperty(RotatedPillarBlock.AXIS)) {
                    sapState = sapState.setValue(
                            RotatedPillarBlock.AXIS,
                            state.getValue(RotatedPillarBlock.AXIS)
                    );
                }

                finalState = sapState;
            }

            blockSetter.accept(placePos, finalState);
        };

        return super.placeTrunk(
                level,
                sapReplacingSetter,
                random,
                freeTreeHeight,
                pos,
                config
        );
    }
}