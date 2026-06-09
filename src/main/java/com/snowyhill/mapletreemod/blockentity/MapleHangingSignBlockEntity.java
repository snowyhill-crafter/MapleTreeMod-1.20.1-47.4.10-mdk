package com.snowyhill.mapletreemod.blockentity;


import com.snowyhill.mapletreemod.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MapleHangingSignBlockEntity extends HangingSignBlockEntity {
    public MapleHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HANGING_SIGN.get(), pos, state);
    }
}
