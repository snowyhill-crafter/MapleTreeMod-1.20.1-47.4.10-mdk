package com.snowyhill.mapletreemod.datagen.server;


import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.registry.ModItems;
import com.snowyhill.mapletreemod.tag.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

import java.util.List;
import java.util.function.Consumer;




public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    @Override
    //1.20.6protected void buildRecipes(RecipeOutput pRecipeOutput)
    //ModItems,ModBlocksには.get()が必要
    protected void buildRecipes(Consumer<FinishedRecipe> pRecipeOutput)  {
            
    woodFromLogs(pRecipeOutput, ModBlocks.MAPLE_WOOD.get(),
                ModBlocks.MAPLE_LOG.get());

    woodFromLogs(pRecipeOutput, ModBlocks.STRIPPED_MAPLE_WOOD.get(),
                ModBlocks.STRIPPED_MAPLE_LOG.get());

    planksFromLog(pRecipeOutput,
                  ModBlocks.MAPLE_PLANKS.get(),

    ModTags.Items.MAPLE_LOG,4);

    slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS,
         ModBlocks.MAPLE_SLAB.get(),
                ModBlocks.MAPLE_PLANKS.get());

    stairs(pRecipeOutput,
           ModBlocks.MAPLE_STAIRS.get(),
                ModBlocks.MAPLE_PLANKS.get());

    fence(pRecipeOutput,
          ModBlocks.MAPLE_FENCE.get(),
                ModBlocks.MAPLE_PLANKS.get());

    fenceGate(pRecipeOutput,
              ModBlocks.MAPLE_FENCE_GATE.get(),
                ModBlocks.MAPLE_PLANKS.get());

    door(pRecipeOutput,
         ModBlocks.MAPLE_DOOR.get(),
                ModBlocks.MAPLE_PLANKS.get());

    trapdoor(pRecipeOutput,
             ModBlocks.MAPLE_TRAPDOOR.get(),
                ModBlocks.MAPLE_PLANKS.get());

    button(pRecipeOutput,
           ModBlocks.MAPLE_BUTTON.get(),
                ModBlocks.MAPLE_PLANKS.get());

    pressurePlate(pRecipeOutput,
                  ModBlocks.MAPLE_PRESSURE_PLATE.get(),
                ModBlocks.MAPLE_PLANKS.get());

        // --- 看板（3個） ---
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.MAPLE_SIGN_ITEM.get(), 3)
                .define('#', ModBlocks.MAPLE_PLANKS.get()) // ←あなたのリンゴ材の板ブロック
                .define('S', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" S ")
                .unlockedBy("has_apple_planks", has(ModBlocks.MAPLE_PLANKS.get()))
                .save(pRecipeOutput);

        // --- 吊り看板（6個） ---
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.MAPLE_HANGING_SIGN_ITEM.get(), 6)
                .define('L', ModBlocks.STRIPPED_MAPLE_LOG.get()) // ←ストリップ済み丸太（同木種）
                .define('C', Items.CHAIN)
                .pattern("C C")
                .pattern("LLL")
                .pattern("LLL")
                .unlockedBy("has_stripped_apple_log", has(ModBlocks.STRIPPED_MAPLE_LOG.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SAP_COLLECTOR.get())
                .pattern(" T ")
                .pattern("SIS")
                .pattern("SSS")
                .define('T', ItemTags.TRAPDOORS)
                .define('I', Items.IRON_INGOT)
                .define('S', ItemTags.WOODEN_SLABS)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(pRecipeOutput);


        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.MAPLE_SAP_BOTTLE.get()),
                        RecipeCategory.FOOD,
                        ModItems.MAPLE_SYRUP_BOTTLE.get(),
                        0.35F,
                        200
                )
                .unlockedBy("has_maple_sap_bottle", has(ModItems.MAPLE_SAP_BOTTLE.get()))
                .save(pRecipeOutput, MapleTreeMod.MOD_ID + ":maple_syrup_bottle_from_smelting");

        /* ビンをどうするか決める
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.MAPLE_SYRUP_BOTTLE.get()),
                        RecipeCategory.FOOD,
                        Items.SUGAR,
                        0.35F,
                        200
                )
                .unlockedBy("has_maple_syrup_bottle", has(ModItems.MAPLE_SYRUP_BOTTLE.get()))
                .save(pRecipeOutput, MapleTreeMod.MOD_ID + ":sugar_from_smelting");
*/

        ShapelessRecipeBuilder.shapeless(
                        RecipeCategory.FOOD,
                        ModItems.MAPLE_TAFFY.get(),
                        3
                )
                .requires(ModItems.MAPLE_SYRUP_BOTTLE.get())
                .requires(Items.SNOWBALL)
                .requires(Items.STICK)
                .unlockedBy(
                        "has_maple_syrup_bottle",
                        has(ModItems.MAPLE_SYRUP_BOTTLE.get())
                )
                .save(pRecipeOutput);




        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.MAPLE_PANCAKE.get())
                .pattern("MMM")
                .pattern("SES")
                .pattern("WWW")
                .define('M', ModItems.MAPLE_SYRUP_BOTTLE.get())
                .define('S', Items.SUGAR)
                .define('E', Items.EGG)
                .define('W', Items.WHEAT)
                .unlockedBy("has_maple_syrup_bottle", has(ModItems.MAPLE_SYRUP_BOTTLE.get()))
                .save(pRecipeOutput);


    }
    // かまど用のレシピ
    protected static void oreSmelting(Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    // 溶鉱炉用のレシピ
    protected static void oreBlasting(Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pRecipeOutput, RecipeSerializer<?
            extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput,
                            MapleTreeMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pRecipeOutput,
                                                  RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory,
                                                  ItemLike pPacked) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pRecipeOutput);
    }

    private static void stairs(Consumer<FinishedRecipe> pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        stairBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void fence(Consumer<FinishedRecipe> pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        fenceBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void fenceGate(Consumer<FinishedRecipe> pRecipeOutput, ItemLike pResult,
                                  ItemLike pIngredient) {
        fenceGateBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void door(Consumer<FinishedRecipe> pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        doorBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void trapdoor(Consumer<FinishedRecipe> pRecipeOutput, ItemLike pResult,
                                 ItemLike pIngredient) {
        trapdoorBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void button(Consumer<FinishedRecipe> pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        buttonBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
}