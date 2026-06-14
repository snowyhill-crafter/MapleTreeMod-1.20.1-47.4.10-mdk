package com.snowyhill.mapletreemod.item;

import com.snowyhill.mapletreemod.block.SapCollectorBlock;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SapCollectorItem extends BlockItem {

    public SapCollectorItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Direction clickedFace = context.getClickedFace();

        if (!clickedFace.getAxis().isHorizontal()) {
            return InteractionResult.FAIL;
        }

        BlockState logState = level.getBlockState(clickedPos);
        if (!logState.is(ModBlocks.MAPLE_SAP_LOG.get())) {
            return InteractionResult.FAIL;
        }

        if (hasCollectorAroundLog(level, clickedPos)) {
            return InteractionResult.FAIL;
        }

        BlockPos placePos = clickedPos.relative(clickedFace);

        if (!level.getBlockState(placePos).canBeReplaced()) {
            return InteractionResult.FAIL;
        }

        BlockState collectorState = ModBlocks.SAP_COLLECTOR.get()
                .defaultBlockState()
                .setValue(SapCollectorBlock.FACING, clickedFace)
                .setValue(SapCollectorBlock.FILL_LEVEL, 0);

        if (!collectorState.canSurvive(level, placePos)) {
            return InteractionResult.FAIL;
        }

        if (!level.isClientSide) {
            level.setBlock(placePos, collectorState, 3);

            level.playSound(
                    null,
                    placePos,
                    SoundEvents.WOODEN_TRAPDOOR_CLOSE,
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F
            );

            if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                context.getItemInHand().shrink(1);
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    private boolean hasCollectorAroundLog(Level level, BlockPos logPos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos checkPos = logPos.relative(direction);
            BlockState checkState = level.getBlockState(checkPos);

            if (checkState.is(ModBlocks.SAP_COLLECTOR.get())) {
                return true;
            }
        }

        return false;
    }
}