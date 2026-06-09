package com.snowyhill.mapletreemod.block;

import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModPressurePlateBlock extends PressurePlateBlock {

    public ModPressurePlateBlock(Properties properties) {
        // Sensitivity は木の感圧板と同じ EVERYTHING
        super(Sensitivity.EVERYTHING, properties, BlockSetType.OAK);
    }

}
