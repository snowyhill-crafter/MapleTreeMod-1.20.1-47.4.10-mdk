package com.snowyhill.mapletreemod.datagen.server.loot;

import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.registry.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.MAPLE_RED_SAPLING.get());

        this.add(ModBlocks.POTTED_MAPLE_RED_SAPLING.get(),
                pottedPlantLoot(ModBlocks.MAPLE_RED_SAPLING.get()));

        this.dropSelf(ModBlocks.MAPLE_ORANGE_SAPLING.get());

        this.add(ModBlocks.POTTED_MAPLE_ORANGE_SAPLING.get(),
                pottedPlantLoot(ModBlocks.MAPLE_ORANGE_SAPLING.get()));


        this.dropSelf(ModBlocks.MAPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD.get());

        this.dropSelf(ModBlocks.MAPLE_PLANKS.get());
        this.dropSelf(ModBlocks.MAPLE_STAIRS.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MAPLE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MAPLE_BUTTON.get());
        this.dropSelf(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        //重ねたときに壊しても二つドロップさせる
        this.add(ModBlocks.MAPLE_SLAB.get(),
                createSlabItemTable(ModBlocks.MAPLE_SLAB.get()));
        //指定しないとドアが二つドロップしてしまうので対処した
        this.add(ModBlocks.MAPLE_DOOR.get(),
                createDoorTable(ModBlocks.MAPLE_DOOR.get()));


        // 立て看板 → sign をドロップ
        this.add(ModBlocks.MAPLE_SIGN.get(),
                block -> createSingleItemTable(ModItems.MAPLE_SIGN_ITEM.get()));

        // 壁看板 → sign をドロップ
        this.add(ModBlocks.MAPLE_WALL_SIGN.get(),
                block -> createSingleItemTable(ModItems.MAPLE_SIGN_ITEM.get()));

        // 吊り看板（天井） → hanging_sign をドロップ
        this.add(ModBlocks.MAPLE_HANGING_SIGN.get(),
                block -> createSingleItemTable(ModItems.MAPLE_HANGING_SIGN_ITEM.get()));

        // 吊り看板（壁） → hanging_sign をドロップ
        this.add(ModBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(ModItems.MAPLE_HANGING_SIGN_ITEM.get()));

        //this.dropSelf(ModBlocks.MAPLE_BED.get());


        // MAPLE_LEAVES
        this.add(ModBlocks.MAPLE_RED_LEAVES.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.MAPLE_RED_LEAVES.get())
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)))
                        )
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.MAPLE_RED_SAPLING.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.05f))
                                .when(
                                        InvertedLootItemCondition.invert(
                                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))
                                        )
                                )
                        )
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02f))
                                .when(
                                        InvertedLootItemCondition.invert(
                                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))
                                        )
                                )
                        )
                )
        );

        this.add(ModBlocks.MAPLE_ORANGE_LEAVES.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.MAPLE_ORANGE_LEAVES.get())
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)))
                        )
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.MAPLE_ORANGE_SAPLING.get())
                                .when(LootItemRandomChanceCondition.randomChance(0.05f))
                                .when(
                                        InvertedLootItemCondition.invert(
                                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))
                                        )
                                )
                        )
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                .when(LootItemRandomChanceCondition.randomChance(0.02f))
                                .when(
                                        InvertedLootItemCondition.invert(
                                                MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))
                                        )
                                )
                        )
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    /** バニラの potted_xxx と同等: flower_pot 1個 + plant 1個（爆発時は中身のみ条件付き） */
    private static LootTable.Builder pottedPlantLoot(ItemLike plant) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.FLOWER_POT)))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(plant))
                        .when(ExplosionCondition.survivesExplosion()));
    }

}
