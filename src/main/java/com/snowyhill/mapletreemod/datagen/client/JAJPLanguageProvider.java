package com.snowyhill.mapletreemod.datagen.client;


import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.registry.ModEntities;
import com.snowyhill.mapletreemod.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, MapleTreeMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {

        addBlock(ModBlocks.MAPLE_RED_SAPLING, "赤いカエデの苗木");
        addBlock(ModBlocks.MAPLE_ORANGE_SAPLING, "橙色のカエデの苗木");
        addBlock(ModBlocks.MAPLE_YELLOW_SAPLING, "黄色のカエデの苗木");

        addBlock(ModBlocks.MAPLE_RED_LEAVES, "赤いカエデの葉");
        addBlock(ModBlocks.MAPLE_ORANGE_LEAVES, "橙色のカエデの葉");
        addBlock(ModBlocks.MAPLE_YELLOW_LEAVES, "黄色のカエデの葉");

        addBlock(ModBlocks.MAPLE_RED_LEAF_LITTER, "赤いカエデの落ち葉");
        addBlock(ModBlocks.MAPLE_ORANGE_LEAF_LITTER, "橙色のカエデの落ち葉");
        addBlock(ModBlocks.MAPLE_YELLOW_LEAF_LITTER, "黄色のカエデの落ち葉");

        addBlock(ModBlocks.MAPLE_LOG, "カエデの原木");
        addBlock(ModBlocks.MAPLE_SAP_LOG, "カエデの樹液付き原木");
        addBlock(ModBlocks.STRIPPED_MAPLE_LOG, "樹皮を剥いだカエデの原木");
        addBlock(ModBlocks.MAPLE_WOOD, "カエデの木");
        addBlock(ModBlocks.STRIPPED_MAPLE_WOOD, "樹皮を剥いだカエデの木");


        addBlock(ModBlocks.MAPLE_PLANKS, "カエデの板材");
        addBlock(ModBlocks.MAPLE_SLAB, "カエデのハーフブロック");
        addBlock(ModBlocks.MAPLE_STAIRS, "カエデの階段");
        addBlock(ModBlocks.MAPLE_FENCE, "カエデのフェンス");
        addBlock(ModBlocks.MAPLE_FENCE_GATE, "カエデのフェンスゲート");
        addBlock(ModBlocks.MAPLE_DOOR, "カエデのドア");
        addBlock(ModBlocks.MAPLE_TRAPDOOR, "カエデのトラップドア");
        addBlock(ModBlocks.MAPLE_BUTTON, "カエデのボタン");
        addBlock(ModBlocks.MAPLE_PRESSURE_PLATE, "カエデの感圧板");

        addBlock(ModBlocks.MAPLE_SIGN, "カエデの看板");
        addBlock(ModBlocks.MAPLE_HANGING_SIGN, "カエデの吊り看板");
        addItem(ModItems.MAPLE_BOAT, "カエデのボート");
        addItem(ModItems.MAPLE_CHEST_BOAT, "チェスト付きのカエデのボート");

        addBlock(ModBlocks.SAP_COLLECTOR, "樹液採取器");
        addItem(ModItems.MAPLE_SAP_BOTTLE, "カエデの樹液入り瓶");
        addItem(ModItems.MAPLE_SYRUP_BOTTLE, "メイプルシロップ入り瓶");
        addItem(ModItems.MAPLE_TAFFY, "メイプルタフィー");
        addItem(ModItems.MAPLE_COOKIE, "メイプルクッキー");
        addBlock(ModBlocks.MAPLE_PANCAKE, "メイプルパンケーキ");

        addEntityType(ModEntities.MOD_CHEST_BOAT, "チェスト付きのボート");
        add("creativetabs.Mod_tab", "カエデの木MOD");
        add("biome.mapletreemod.maple_forest", "カエデの森");

    }
}