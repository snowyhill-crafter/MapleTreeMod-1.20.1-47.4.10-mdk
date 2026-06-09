package com.snowyhill.mapletreemod.block;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModDoorBlock extends DoorBlock {

    public ModDoorBlock(Properties properties) {
        super(properties, BlockSetType.OAK);  // ← これが正しい
    }

}
