package com.snowyhill.mapletreemod.registry;

import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.block.*;
import com.snowyhill.mapletreemod.client.ModWoodTypes;
import com.snowyhill.mapletreemod.particle.ModParticleTypes;
import com.snowyhill.mapletreemod.worldgen.tree.MapleOrangeTreeGrower;
import com.snowyhill.mapletreemod.worldgen.tree.MapleRedTreeGrower;
import com.snowyhill.mapletreemod.worldgen.tree.MapleYellowTreeGrower;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MapleTreeMod.MOD_ID);



    public static final RegistryObject<Block> MAPLE_RED_SAPLING = BLOCKS.register(
            "maple_red_sapling",
            () -> new SaplingBlock(new MapleRedTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> POTTED_MAPLE_RED_SAPLING = BLOCKS.register(
            "potted_maple_red_sapling",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    ModBlocks.MAPLE_RED_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

    public static final RegistryObject<Block> MAPLE_ORANGE_SAPLING = BLOCKS.register(
            "maple_orange_sapling",
            () -> new SaplingBlock(new MapleOrangeTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> POTTED_MAPLE_ORANGE_SAPLING = BLOCKS.register(
            "potted_maple_orange_sapling",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    ModBlocks.MAPLE_ORANGE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

    public static final RegistryObject<Block> MAPLE_YELLOW_SAPLING = BLOCKS.register(
            "maple_yellow_sapling",
            () -> new SaplingBlock(new MapleYellowTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> POTTED_MAPLE_YELLOW_SAPLING = BLOCKS.register(
            "potted_maple_yellow_sapling",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    ModBlocks.MAPLE_YELLOW_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));


    public static final RegistryObject<Block> MAPLE_LOG = BLOCKS.register("maple_log",
            () -> new ModStrippableLogBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_LOG),
                    () -> ModBlocks.STRIPPED_MAPLE_LOG.get()
            )
    );

    public static final RegistryObject<Block> MAPLE_SAP_LOG = BLOCKS.register("maple_sap_log",
            () -> new ModStrippableLogBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_LOG),
                    () -> ModBlocks.STRIPPED_MAPLE_LOG.get()
            )
    );


    // 樹皮はがし後（stripped）原木
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = BLOCKS.register("stripped_maple_log",
            () -> new ModLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG))
    );

    public static final RegistryObject<Block> MAPLE_WOOD = BLOCKS.register("maple_wood",
            () -> new ModStrippableLogBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
                    () -> ModBlocks.STRIPPED_MAPLE_WOOD.get()
            )
    );
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = BLOCKS.register("stripped_maple_wood",
            () -> new ModLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD))
    );



    //クラフト
// 板材
    public static final RegistryObject<Block> MAPLE_PLANKS = BLOCKS.register(
            "maple_planks",
            () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    // ハーフブロック
    public static final RegistryObject<Block> MAPLE_SLAB = BLOCKS.register(
            "maple_slab",
            () -> new ModSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB))
    );
    // 階段
    public static final RegistryObject<Block> MAPLE_STAIRS = BLOCKS.register(
            "maple_stairs",
            () -> new ModStairBlock(
                    () -> ModBlocks.MAPLE_PLANKS.get().defaultBlockState(), // ← Supplier<BlockState>
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
            )
    );
    // フェンス
    public static final RegistryObject<Block> MAPLE_FENCE = BLOCKS.register(
            "maple_fence",
            () -> new ModFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE))
    );
    // フェンスゲート
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = BLOCKS.register(
            "maple_fence_gate",
            () -> new ModFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE))
    );
    // ドア
    public static final RegistryObject<Block> MAPLE_DOOR = BLOCKS.register(
            "maple_door",
            () -> new ModDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR))
    );
    // トラップドア
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = BLOCKS.register(
            "maple_trapdoor",
            () -> new ModTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR))
    );
    // ボタン
    public static final RegistryObject<Block> MAPLE_BUTTON = BLOCKS.register(
            "maple_button",
            () -> new ModButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON))
    );
    // 感圧板
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = BLOCKS.register(
            "maple_pressure_plate",
            () -> new ModPressurePlateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE))
    );

    public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("maple_sign",
            () -> new ModStandingSignBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .strength(1.0F)
                            .sound(SoundType.WOOD)
                            .noOcclusion() //光・描写を阻害しない
                            .noCollission(), //衝突無し
                    ModWoodTypes.MAPLE
            ));

    public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign",
            () -> new ModWallSignBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .strength(1.0F)
                            .sound(SoundType.WOOD)
                            .noOcclusion() //光・描写を阻害しない
                            .noCollission(), //衝突無し
                    ModWoodTypes.MAPLE
            ));

    public static final RegistryObject<Block> MAPLE_HANGING_SIGN = BLOCKS.register("maple_hanging_sign",
            () -> new ModCeilingHangingSignBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .strength(1.0F)
                            .sound(SoundType.WOOD)
                            .noOcclusion() //光・描写を阻害しない
                            .noCollission(), //衝突無し
                    ModWoodTypes.MAPLE
            ));

    public static final RegistryObject<Block> MAPLE_WALL_HANGING_SIGN = BLOCKS.register("maple_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .strength(1.0F)
                            .sound(SoundType.WOOD)
                            .noOcclusion() //光・描写を阻害しない
                            .noCollission(), //衝突無し
                    ModWoodTypes.MAPLE
            ));


    public static final RegistryObject<Block> MAPLE_RED_LEAVES = BLOCKS.register(
            "maple_red_leaves",
            () -> new MapleLeavesBlock(
                    ModParticleTypes.MAPLE_RED_LEAF,
                    BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).randomTicks()
            )
    );

    public static final RegistryObject<Block> MAPLE_ORANGE_LEAVES = BLOCKS.register(
            "maple_orange_leaves",
            () -> new MapleLeavesBlock(
                    ModParticleTypes.MAPLE_ORANGE_LEAF,
                    BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).randomTicks()
            )
    );

    public static final RegistryObject<Block> MAPLE_YELLOW_LEAVES = BLOCKS.register(
            "maple_yellow_leaves",
            () -> new MapleLeavesBlock(
                    ModParticleTypes.MAPLE_YELLOW_LEAF,
                    BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).randomTicks()
            )
    );

    public static final RegistryObject<Block> MAPLE_RED_LEAF_LITTER = BLOCKS.register(
            "maple_red_leaf_litter",
            () -> new MapleLeafLitterBlock(
                    BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)
            )
    );

    public static final RegistryObject<Block> MAPLE_ORANGE_LEAF_LITTER = BLOCKS.register(
            "maple_orange_leaf_litter",
            () -> new MapleLeafLitterBlock(
                    BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)
            )
    );

    public static final RegistryObject<Block> MAPLE_YELLOW_LEAF_LITTER = BLOCKS.register(
            "maple_yellow_leaf_litter",
            () -> new MapleLeafLitterBlock(
                    BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)
            )
    );

    public static final RegistryObject<Block> SAP_COLLECTOR = BLOCKS.register(
            "sap_collector",
            () -> new SapCollectorBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
                            .randomTicks()   // ←この指定が必須！
            )
    );

    public static final RegistryObject<Block> MAPLE_PANCAKE = BLOCKS.register("maple_pancake",
            () -> new MaplePancakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion()));






    // イベントバスに登録
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}

