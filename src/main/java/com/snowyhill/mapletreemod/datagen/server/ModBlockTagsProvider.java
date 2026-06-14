package com.snowyhill.mapletreemod.datagen.server;



import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public  class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MapleTreeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN).add(
                ModBlocks.MAPLE_LOG.get(),
                ModBlocks.STRIPPED_MAPLE_LOG.get(),
                ModBlocks.MAPLE_WOOD.get(),
                ModBlocks.STRIPPED_MAPLE_WOOD.get()
        );

        this.tag(BlockTags.LEAVES)
                .add(
                        ModBlocks.MAPLE_RED_LEAVES.get(),
                        ModBlocks.MAPLE_ORANGE_LEAVES.get()
                );

        this.tag(BlockTags.LOGS)
                .add(
                        ModBlocks.MAPLE_LOG.get(),
                        ModBlocks.MAPLE_SAP_LOG.get()
                );



        this.tag(ModTags.Blocks.MAPLE_LOG)
                .add(
                        ModBlocks.MAPLE_LOG.get(),
                        ModBlocks.MAPLE_SAP_LOG.get(),
                        ModBlocks.STRIPPED_MAPLE_LOG.get(),
                        ModBlocks.MAPLE_WOOD.get(),
                        ModBlocks.STRIPPED_MAPLE_WOOD.get()
                );



        // ←採掘速度に効くのはこっち
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.MAPLE_SLAB.get(),
                ModBlocks.MAPLE_FENCE.get(),
                ModBlocks.MAPLE_FENCE_GATE.get(),
                ModBlocks.MAPLE_DOOR.get(),
                ModBlocks.MAPLE_TRAPDOOR.get(),
                ModBlocks.MAPLE_STAIRS.get(),
                ModBlocks.MAPLE_BUTTON.get(),
                ModBlocks.MAPLE_PRESSURE_PLATE.get(),

                ModBlocks.MAPLE_SIGN.get(),
                ModBlocks.MAPLE_WALL_SIGN.get(),
                ModBlocks.MAPLE_HANGING_SIGN.get(),
                ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),

                ModBlocks.SAP_COLLECTOR.get()
        );

        this.tag(BlockTags.SAPLINGS).add(
                ModBlocks.MAPLE_RED_SAPLING.get(),
                ModBlocks.MAPLE_ORANGE_SAPLING.get(),
                ModBlocks.MAPLE_YELLOW_SAPLING.get()
        );


        this.tag(BlockTags.PLANKS).add(
                ModBlocks.MAPLE_PLANKS.get()
        );
        this.tag(BlockTags.SLABS).add(
                ModBlocks.MAPLE_SLAB.get()
        );

        this.tag(BlockTags.WOODEN_SLABS).add(
                ModBlocks.MAPLE_SLAB.get()
        );


        this.tag(BlockTags.STAIRS).add(
                ModBlocks.MAPLE_STAIRS.get()
        );
        this.tag(BlockTags.FENCES).add(
                ModBlocks.MAPLE_FENCE.get()
        );
        this.tag(BlockTags.FENCE_GATES).add(
                ModBlocks.MAPLE_FENCE_GATE.get()
        );
        this.tag(BlockTags.DOORS).add(
                ModBlocks.MAPLE_DOOR.get()
          );
        this.tag(BlockTags.TRAPDOORS).add(
                ModBlocks.MAPLE_TRAPDOOR.get()
        );
        this.tag(BlockTags.BUTTONS).add(
                ModBlocks.MAPLE_BUTTON.get()
        );
        this.tag(BlockTags.PRESSURE_PLATES).add(
                ModBlocks.MAPLE_PRESSURE_PLATE.get()
        );

        // 看板系（バニラ準拠の分類）
        //tag(BlockTags.STANDING_SIGNS).add(ModBlocks.MAPLE_SIGN.get());
        //tag(BlockTags.WALL_SIGNS).add(ModBlocks.MAPLE_WALL_SIGN.get());

        //tag(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.MAPLE_HANGING_SIGN.get());
        //tag(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.MAPLE_WALL_HANGING_SIGN.get());

    }
}






