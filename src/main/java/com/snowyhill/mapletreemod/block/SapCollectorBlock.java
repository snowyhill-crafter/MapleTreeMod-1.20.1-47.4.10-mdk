package com.snowyhill.mapletreemod.block;

import com.snowyhill.mapletreemod.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;


public class SapCollectorBlock extends Block {
    // 満タン段階（0=空, 3=満タン）
    public static final IntegerProperty FILL_LEVEL = IntegerProperty.create("fill_level", 0, 3);
    // 吸着方向（北東南西）
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    public SapCollectorBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FILL_LEVEL, 0)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();

        // 上下には設置不可
        if (clickedFace.getAxis().isVertical()) {
            return null;
        }

        BlockState clickedState = context.getLevel().getBlockState(context.getClickedPos());

        // クリック先が樹液原木でなければ不可
        if (!clickedState.is(ModBlocks.MAPLE_SAP_LOG.get())) {
            return null;
        }

        // 樹液が出ている面
        Direction sapFacing = clickedState.getValue(MapleSapLogBlock.FACING);

        // クリックした面と樹液面が一致した時だけ設置可
        if (clickedFace != sapFacing) {
            return null;
        }

        return this.defaultBlockState()
                .setValue(FILL_LEVEL, 0)
                .setValue(FACING, clickedFace);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FILL_LEVEL, FACING);
    }

    // 木（maple_sap_log）の側面以外には絶対に生存できない
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction facing = state.getValue(FACING);

        BlockPos attachedPos = pos.relative(facing.getOpposite());
        BlockState attachedState = level.getBlockState(attachedPos);

        if (!attachedState.is(ModBlocks.MAPLE_SAP_LOG.get())) {
            return false;
        }

        Direction sapFacing = attachedState.getValue(MapleSapLogBlock.FACING);

        return sapFacing == facing;
    }

    @Override
    public void neighborChanged(BlockState state, net.minecraft.world.level.Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!canSurvive(state, level, pos)) {
            // アイテム化＆自壊
            level.destroyBlock(pos, true); // trueでアイテムドロップあり
        }
        super.neighborChanged(state, level, pos, blockIn, fromPos, isMoving);
    }


    // コリジョンを設置向きによって切り替え
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);

        switch (facing) {
            case NORTH:
                // X=2～14, Y=0～11, Z=0～8
                return Shapes.box(2.0/16, 0.0/16, 8.0/16, 14.0/16, 11.0/16, 16.0/16);
            case SOUTH:
                // X=2～14, Y=0～11, Z=0～8
                return Shapes.box(2.0/16, 0.0/16, 0.0/16, 14.0/16, 11.0/16, 8.0/16);
            case WEST:
                // X=8～16, Y=0～11, Z=2～14
                return Shapes.box(8.0/16, 0.0/16, 2.0/16, 16.0/16, 11.0/16, 14.0/16);
            case EAST:
                // X=0～8, Y=0～11, Z=2～14
                return Shapes.box(0.0/16, 0.0/16, 2.0/16, 8.0/16, 11.0/16, 14.0/16);
            default:
                return Shapes.block();
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return this.getShape(state, world, pos, context);
    }


    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        // ブロックの形状で遮蔽するかどうか
        return false; // ←完全な無視
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter world, BlockPos pos) {
        // 空の光を下まで通す（完全に光を通したい場合true）
        return true;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos) {
        // ブロックが“遮る”光量（0で光を通す。15だと完全遮断）
        return 0;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int current = state.getValue(FILL_LEVEL);

        if (current < 3) {
            if (random.nextInt(10) == 0) {
                int newLevel = current + 1;

                level.setBlock(pos, state.setValue(FILL_LEVEL, newLevel), 3);

                if (newLevel == 3) {
                    level.playSound(
                            null,
                            pos,
                            SoundEvents.HONEY_BLOCK_SLIDE,
                            SoundSource.BLOCKS,
                            0.8F,
                            1.0F
                    );
                }
            }
        }
    }
}








