package com.snowyhill.mapletreemod.client;


import com.snowyhill.mapletreemod.MapleTreeMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;


public final class ModWoodTypes {
    // 名前を "appletreemod:apple" に変更する
    public static final WoodType MAPLE =
            WoodType.register(new WoodType(MapleTreeMod.MOD_ID + ":maple", BlockSetType.OAK));


}