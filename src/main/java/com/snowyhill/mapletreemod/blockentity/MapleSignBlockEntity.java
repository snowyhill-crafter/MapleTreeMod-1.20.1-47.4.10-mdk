package com.snowyhill.mapletreemod.blockentity;


import com.snowyhill.mapletreemod.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MapleSignBlockEntity extends SignBlockEntity {
    public MapleSignBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SIGN.get(), pos, state);
    }
}
