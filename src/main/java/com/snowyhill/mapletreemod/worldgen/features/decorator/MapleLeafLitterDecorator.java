package com.snowyhill.mapletreemod.worldgen.features.decorator;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class MapleLeafLitterDecorator extends TreeDecorator {

    public static final Codec<MapleLeafLitterDecorator> CODEC =
            BuiltInRegistries.BLOCK.byNameCodec().xmap(
                    MapleLeafLitterDecorator::new,
                    decorator -> decorator.leafLitter
            );

    private final Block leafLitter;

    public MapleLeafLitterDecorator(Block leafLitter) {
        this.leafLitter = leafLitter;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecorators.MAPLE_LEAF_LITTER.get();
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();

        for (BlockPos logPos : context.logs()) {

            // 数を増やしたいならここを増やすi < 12
            for (int i = 0; i < 12; i++)  {

                BlockPos groundPos = logPos.offset(
                        random.nextInt(9) - 4,
                        -1,
                        random.nextInt(9) - 4
                );

                BlockPos placePos = groundPos.above();

                if (context.isAir(placePos) && !context.isAir(groundPos)) {

                    BlockState state = leafLitter.defaultBlockState();

                    // Pink Petals系の段階 1〜4
                    if (state.hasProperty(BlockStateProperties.FLOWER_AMOUNT)) {
                        state = state.setValue(
                                BlockStateProperties.FLOWER_AMOUNT,
                                randomLeafAmount(random)
                        );
                    }

                    // 向きもランダムにする
                    if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                        state = state.setValue(
                                BlockStateProperties.HORIZONTAL_FACING,
                                Direction.Plane.HORIZONTAL.getRandomDirection(random)
                        );
                    }

                    context.setBlock(placePos, state);
                }
            }
        }
    }

    private int randomLeafAmount(RandomSource random) {
        int amount = 1;

        if (random.nextFloat() < 0.35F) amount++;
        if (random.nextFloat() < 0.15F) amount++;
        if (random.nextFloat() < 0.05F) amount++;

        return amount;
    }
}