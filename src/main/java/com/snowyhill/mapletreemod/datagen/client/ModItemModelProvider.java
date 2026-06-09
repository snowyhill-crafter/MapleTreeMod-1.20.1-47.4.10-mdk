package com.snowyhill.mapletreemod.datagen.client;


import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MapleTreeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //ここにアイテムを追加して自動生成させる
        

        itemWithBlock(ModBlocks.MAPLE_SLAB);
        itemWithBlock(ModBlocks.MAPLE_STAIRS);
        itemWithBlock(ModBlocks.MAPLE_FENCE_GATE);
        itemWithBlock(ModBlocks.MAPLE_PRESSURE_PLATE);
        basicItem(ModBlocks.MAPLE_DOOR.get().asItem());
        trapdoor(ModBlocks.MAPLE_TRAPDOOR);
        fence(ModBlocks.MAPLE_FENCE,
                ModBlocks.MAPLE_PLANKS);
        button(ModBlocks.MAPLE_BUTTON,
                ModBlocks.MAPLE_PLANKS);
        // 看板（手持ちアイテム）
        singleTexture("maple_sign",
                new ResourceLocation("item/generated"),
                "layer0",
                modLoc("item/maple_sign"));

        // 吊り看板（手持ちアイテム）
        singleTexture("maple_hanging_sign",
                new ResourceLocation("item/generated"),
                "layer0",
                modLoc("item/maple_hanging_sign"));

        // 通常のボート
        basicItem(ModItems.MAPLE_BOAT.get());

        // チェスト付きボート
        basicItem(ModItems.MAPLE_CHEST_BOAT.get());


        sapling(ModBlocks.MAPLE_RED_SAPLING);
        sapling(ModBlocks.MAPLE_ORANGE_SAPLING);

    }

    public void itemWithBlock(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        MapleTreeMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoor(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        MapleTreeMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fence(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(MapleTreeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void button(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(MapleTreeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private void sapling(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MapleTreeMod.MOD_ID,"block/" + block.getId().getPath()));
    }



}
