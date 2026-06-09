package com.snowyhill.mapletreemod.datagen.client;



import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MapleTreeMod.MOD_ID, exFileHelper);
    }

    @Override
    //ここにブロックを追加し自動生成させる
    //logBlock((RotatedPillarBlock)とaxisBlock((RotatedPillarBlock)はアイテムJSONを生成しないので別途登録
    protected void registerStatesAndModels() {

// --- 1) 苗木 ---
        ModelFile MapleRedSaplingModel = models()
                .cross(regPath(ModBlocks.MAPLE_RED_SAPLING.get()), modLoc("block/maple_red_sapling"))
                .renderType("cutout");
        simpleBlock(ModBlocks.MAPLE_RED_SAPLING.get(), MapleRedSaplingModel);

// --- 2) 鉢植え苗木 ---
        ModelFile MapleRedPottedModel = models()
                .withExistingParent(regPath(ModBlocks.POTTED_MAPLE_RED_SAPLING.get()), mcLoc("block/flower_pot_cross"))
                .texture("plant", modLoc("block/maple_red_sapling"))
                .renderType("cutout");
        simpleBlock(ModBlocks.POTTED_MAPLE_RED_SAPLING.get(), MapleRedPottedModel);

// --- 1) 苗木 ---
        ModelFile MapleOrangeSaplingModel = models()
                .cross(regPath(ModBlocks.MAPLE_ORANGE_SAPLING.get()), modLoc("block/maple_orange_sapling"))
                .renderType("cutout");
        simpleBlock(ModBlocks.MAPLE_ORANGE_SAPLING.get(), MapleOrangeSaplingModel);

// --- 2) 鉢植え苗木 ---
        ModelFile MapleOrangePottedModel = models()
                .withExistingParent(regPath(ModBlocks.POTTED_MAPLE_ORANGE_SAPLING.get()), mcLoc("block/flower_pot_cross"))
                .texture("plant", modLoc("block/maple_orange_sapling"))
                .renderType("cutout");
        simpleBlock(ModBlocks.POTTED_MAPLE_ORANGE_SAPLING.get(), MapleOrangePottedModel);

        simpleLeaves(ModBlocks.MAPLE_RED_LEAVES);

        simpleLeaves(ModBlocks.MAPLE_ORANGE_LEAVES);


        logBlock((RotatedPillarBlock) ModBlocks.MAPLE_LOG.get());
        item(ModBlocks.MAPLE_LOG);//ログブロックとアクシズブロックはアイテムモデルを自動生成しないし作っても消される。

        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_LOG.get());
        item(ModBlocks.STRIPPED_MAPLE_LOG);


        axisBlock((RotatedPillarBlock) ModBlocks.MAPLE_WOOD.get(),
                blockTexture(ModBlocks.MAPLE_LOG.get()),
                blockTexture(ModBlocks.MAPLE_LOG.get()));
        item(ModBlocks.MAPLE_WOOD);

        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_WOOD.get(),
                blockTexture(ModBlocks.STRIPPED_MAPLE_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_MAPLE_LOG.get()));
        item(ModBlocks.STRIPPED_MAPLE_WOOD);

        simpleBlockWithItem(ModBlocks.MAPLE_PLANKS);
        slabBlock((SlabBlock) ModBlocks.MAPLE_SLAB.get(),
                // 二つ重ねたときのテクスチャ
                blockTexture(ModBlocks.MAPLE_PLANKS.get()),
                // 単体のテクスチャ
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        stairsBlock((StairBlock) ModBlocks.MAPLE_STAIRS.get(),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.MAPLE_FENCE.get(),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.MAPLE_FENCE_GATE.get(),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.MAPLE_DOOR.get(),
                modLoc("block/maple_door_bottom"),
                modLoc("block/maple_door_top"),
                "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock)
                        ModBlocks.MAPLE_TRAPDOOR.get(),
                modLoc("block/maple_trapdoor"), true,
                "cutout");
        buttonBlock((ButtonBlock) ModBlocks.MAPLE_BUTTON.get(),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock)
                        ModBlocks.MAPLE_PRESSURE_PLATE.get(),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));


        signBlock(
                (StandingSignBlock) ModBlocks.MAPLE_SIGN.get(),
                (WallSignBlock) ModBlocks.MAPLE_WALL_SIGN.get(),
                blockTexture(ModBlocks.MAPLE_PLANKS.get())
        );


    }

    private void simpleBlockWithItem(RegistryObject<Block> block){

        simpleBlockWithItem(block.get() , cubeAll(block.get()));
    }



    /** 登録パス（apple_sapling など） */
    private static String regPath(Block b) {
        return ForgeRegistries.BLOCKS.getKey(b).getPath();
    }

    // ブロック用のアイテムモデルを作成
    private void item(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(
                MapleTreeMod.MOD_ID + ":block/" +
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath()
        ));
    }

    // 普通の葉ブロック
    private void simpleLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("minecraft:block/leaves"),
                "all", blockTexture(block.get())).renderType("cutout"));
    }

    private void sapling(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }



}
