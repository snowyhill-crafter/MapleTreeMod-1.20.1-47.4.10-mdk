package com.snowyhill.mapletreemod.datagen.client;


import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.registry.ModEntities;
import com.snowyhill.mapletreemod.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, MapleTreeMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addBlock(ModBlocks.MAPLE_RED_SAPLING, "Maple Red Saplings");
        addBlock(ModBlocks.MAPLE_ORANGE_SAPLING, "Maple Orange Saplings");
        addBlock(ModBlocks.MAPLE_YELLOW_SAPLING, "Maple Yellow Saplings");

        addBlock(ModBlocks.MAPLE_RED_LEAVES, "Maple Red Leaves");
        addBlock(ModBlocks.MAPLE_ORANGE_LEAVES, "Maple Orange Leaves");
        addBlock(ModBlocks.MAPLE_YELLOW_LEAVES, "Maple Yellow Leaves");

        addBlock(ModBlocks.MAPLE_LOG, "Maple Log");
        addBlock(ModBlocks.STRIPPED_MAPLE_LOG, "Stripped Maple Log");
        addBlock(ModBlocks.MAPLE_WOOD, "Maple Wood");
        addBlock(ModBlocks.STRIPPED_MAPLE_WOOD, "Stripped Maple Wood");


        addBlock(ModBlocks.MAPLE_PLANKS, "Maple Planks");
        addBlock(ModBlocks.MAPLE_SLAB, "Maple Slab");
        addBlock(ModBlocks.MAPLE_STAIRS, "Maple Stairs");
        addBlock(ModBlocks.MAPLE_FENCE, "Maple Fence");
        addBlock(ModBlocks.MAPLE_FENCE_GATE, "Maple Fence Gate");
        addBlock(ModBlocks.MAPLE_DOOR, "Maple Door");
        addBlock(ModBlocks.MAPLE_TRAPDOOR, "Maple Trapdoor");
        addBlock(ModBlocks.MAPLE_BUTTON, "Maple Button");
        addBlock(ModBlocks.MAPLE_PRESSURE_PLATE, "Maple Pressure Plate");

        addBlock(ModBlocks.MAPLE_SIGN, "Maple Sign");
        addBlock(ModBlocks.MAPLE_HANGING_SIGN, "Maple Hanging Sign");
        addItem(ModItems.MAPLE_BOAT, "Maple Boat");
        addItem(ModItems.MAPLE_CHEST_BOAT, "Maple Chest Boat");



        addEntityType(ModEntities.MOD_CHEST_BOAT, "Boat with Chest");
        add("creativetabs.Mod_tab", "mapletreemod");
        

    }
    
    
}