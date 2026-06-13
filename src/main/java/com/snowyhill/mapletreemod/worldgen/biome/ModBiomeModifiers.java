package com.snowyhill.mapletreemod.worldgen.biome;




import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.worldgen.placement.ModPlacement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;



public class ModBiomeModifiers {

//リソースキー

    // 木用キー
    public static final ResourceKey<BiomeModifier> ADD_MAPLE_RED_TREE =
            createKey("add_maple_red_tree");

    public static final ResourceKey<BiomeModifier> ADD_MAPLE_ORANGE_TREE =
            createKey("add_maple_orange_tree");

    public static final ResourceKey<BiomeModifier> ADD_MAPLE_YELLOW_TREE =
            createKey("add_maple_yellow_tree");

    //バイオームに生成するメソッド
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
/*
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);



        TagKey<Biome> MapleRedTreeBiomeTag = TagKey.create(Registries.BIOME,
                new ResourceLocation("mapletreemod", "maple_red_tree_spawnable"));

        context.register(ADD_MAPLE_RED_TREE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(MapleRedTreeBiomeTag), // ✅ biomeタグとして扱う
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.MAPLE_RED_TREE)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );

        TagKey<Biome> MapleOrangeTreeBiomeTag = TagKey.create(Registries.BIOME,
                new ResourceLocation("mapletreemod", "maple_orange_tree_spawnable"));

        context.register(ADD_MAPLE_ORANGE_TREE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(MapleOrangeTreeBiomeTag), // ✅ biomeタグとして扱う
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.MAPLE_ORANGE_TREE)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );

        TagKey<Biome> MapleYellowTreeBiomeTag = TagKey.create(Registries.BIOME,
                new ResourceLocation("mapletreemod", "maple_yellow_tree_spawnable"));

        context.register(ADD_MAPLE_YELLOW_TREE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(MapleYellowTreeBiomeTag), // ✅ biomeタグとして扱う
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.MAPLE_ORANGE_TREE)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
*/

    }


    //登録用メソッド
    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                new ResourceLocation(MapleTreeMod.MOD_ID,name));
    }


}
