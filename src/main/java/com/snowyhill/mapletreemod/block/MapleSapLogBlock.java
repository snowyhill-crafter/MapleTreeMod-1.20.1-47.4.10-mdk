package com.snowyhill.mapletreemod.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.function.Supplier;

public class MapleSapLogBlock extends RotatedPillarBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private final Supplier<Block> strippedBlock;

    public MapleSapLogBlock(Properties properties, Supplier<Block> strippedBlock) {
        super(properties);
        this.strippedBlock = strippedBlock;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AXIS, Direction.Axis.Y)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context,
                                           ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolActions.AXE_STRIP) {
            return strippedBlock.get().defaultBlockState()
                    .setValue(RotatedPillarBlock.AXIS, state.getValue(AXIS));
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, FACING);
    }
}