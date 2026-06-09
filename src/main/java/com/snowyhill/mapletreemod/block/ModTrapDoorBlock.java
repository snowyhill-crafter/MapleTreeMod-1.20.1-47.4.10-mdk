package com.snowyhill.mapletreemod.block;


import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModTrapDoorBlock extends TrapDoorBlock {

    public ModTrapDoorBlock(Properties properties) {
        super(properties, BlockSetType.OAK);  // ← 木材のトラップドア
    }




}