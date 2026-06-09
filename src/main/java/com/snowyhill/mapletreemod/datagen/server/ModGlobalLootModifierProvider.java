package com.snowyhill.mapletreemod.datagen.server;



import com.snowyhill.mapletreemod.MapleTreeMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output){
    super(output, MapleTreeMod.MOD_ID);
}

    @Override
    protected void start() {    }
}