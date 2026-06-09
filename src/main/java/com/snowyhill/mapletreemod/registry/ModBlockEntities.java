package com.snowyhill.mapletreemod.registry;


import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.blockentity.MapleHangingSignBlockEntity;
import com.snowyhill.mapletreemod.blockentity.MapleSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MapleTreeMod.MOD_ID);

    /* ========= 通常の看板 ========= */

    public static final RegistryObject<BlockEntityType<MapleSignBlockEntity>> SIGN =
            BLOCK_ENTITIES.register("maple_sign",
                    () -> BlockEntityType.Builder.of(
                            MapleSignBlockEntity::new,
                            ModBlocks.MAPLE_SIGN.get(),
                            ModBlocks.MAPLE_WALL_SIGN.get()
                    ).build(null));

    public static final RegistryObject<BlockEntityType<MapleHangingSignBlockEntity>> HANGING_SIGN =
            BLOCK_ENTITIES.register("maple_hanging_sign",
                    () -> BlockEntityType.Builder.of(
                            MapleHangingSignBlockEntity::new,
                            ModBlocks.MAPLE_HANGING_SIGN.get(),
                            ModBlocks.MAPLE_WALL_HANGING_SIGN.get()
                    ).build(null));


   // public static final RegistryObject<BlockEntityType<BedBlockEntity>> COCONUT_BED_BE =
   //         BLOCK_ENTITIES.register("maple_bed",
   //                 () -> BlockEntityType.Builder.of(BedBlockEntity::new, ModBlocks.MAPLE_BED.get()).build(null));
    /* ========= register ========= */

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
