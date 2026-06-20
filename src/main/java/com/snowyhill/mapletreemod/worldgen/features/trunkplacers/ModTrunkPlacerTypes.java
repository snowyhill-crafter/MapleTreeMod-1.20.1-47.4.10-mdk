package com.snowyhill.mapletreemod.worldgen.features.trunkplacers;

import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.worldgen.features.trunkplacers.MapleSapTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, MapleTreeMod.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<MapleSapTrunkPlacer>> MAPLE_SAP_TRUNK_PLACER =
            TRUNK_PLACER_TYPES.register("maple_sap_trunk_placer",
                    () -> new TrunkPlacerType<>(MapleSapTrunkPlacer.CODEC));

    public static final RegistryObject<TrunkPlacerType<MapleSapFancyTrunkPlacer>> MAPLE_SAP_FANCY_TRUNK_PLACER =
            TRUNK_PLACER_TYPES.register("maple_sap_fancy_trunk_placer",
                    () -> new TrunkPlacerType<>(MapleSapFancyTrunkPlacer.CODEC));

}