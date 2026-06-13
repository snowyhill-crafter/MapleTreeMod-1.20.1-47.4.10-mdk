package com.snowyhill.mapletreemod.worldgen.features.decorator;

import com.snowyhill.mapletreemod.MapleTreeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTreeDecorators {

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, MapleTreeMod.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<MapleLeafLitterDecorator>> MAPLE_LEAF_LITTER =
            TREE_DECORATORS.register("maple_leaf_litter",
                    () -> new TreeDecoratorType<>(MapleLeafLitterDecorator.CODEC));
}