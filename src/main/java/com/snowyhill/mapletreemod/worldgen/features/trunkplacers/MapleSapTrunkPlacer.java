package com.snowyhill.mapletreemod.worldgen.features.trunkplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.snowyhill.mapletreemod.block.MapleSapLogBlock;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.worldgen.features.trunkplacers.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class MapleSapTrunkPlacer extends TrunkPlacer {

    public static final Codec<MapleSapTrunkPlacer> CODEC =
            RecordCodecBuilder.create(instance ->
                    trunkPlacerParts(instance)
                            .and(Codec.floatRange(0.0F, 1.0F)
                                    .fieldOf("sap_chance")
                                    .forGetter(placer -> placer.sapChance))
                            .apply(instance, MapleSapTrunkPlacer::new)
            );

    private final float sapChance;

    public MapleSapTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, float sapChance) {
        super(baseHeight, heightRandA, heightRandB);
        this.sapChance = sapChance;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.MAPLE_SAP_TRUNK_PLACER.get();
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
        setDirtAt(level, blockSetter, random, pos.below(), config);

        boolean hasSapLog = random.nextFloat() < this.sapChance;
        Direction sapFacing = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        for (int i = 0; i < freeTreeHeight; i++) {
            BlockPos logPos = pos.above(i);

            BlockState logState;

            if (hasSapLog && i == 1) {
                logState = ModBlocks.MAPLE_SAP_LOG.get().defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)
                        .setValue(MapleSapLogBlock.FACING, sapFacing);
            } else {
                logState = ModBlocks.MAPLE_LOG.get().defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y);
            }

            blockSetter.accept(logPos, logState);
        }

        return List.of(
                new FoliagePlacer.FoliageAttachment(pos.above(freeTreeHeight), 0, false)
        );
    }


}