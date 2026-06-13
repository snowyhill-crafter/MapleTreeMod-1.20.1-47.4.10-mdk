package com.snowyhill.mapletreemod.worldgen.biome;

import com.snowyhill.mapletreemod.MapleTreeMod;
import com.snowyhill.mapletreemod.worldgen.placement.ModPlacement;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> MAPLE_FOREST =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(MapleTreeMod.MOD_ID, "maple_forest"));

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(MAPLE_FOREST, mapleforest(context));
    }

    // OverworldBiomesクラスからコピー
    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static Biome mapleforest(BootstapContext<Biome> context) {

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // ヒツジなど
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        // ゾンビ、スケルトン、クリーパーなど
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        spawnBuilder.addSpawn(
                MobCategory.CREATURE,
                new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4)
        );

        spawnBuilder.addSpawn(
                MobCategory.CREATURE,
                new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 2, 4)
        );

        spawnBuilder.addSpawn(
                MobCategory.CREATURE,
                new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3)
        );

        // Carver：渓谷や洞窟を設置するもの
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));

        // バニラの設定をいい感じにコピってくる（順番をバニラ通りにしないとエラーが起きる）
        globalOverworldGeneration(biomeBuilder);//地上を生成
        //BiomeDefaultFeatures.addFerns(biomeBuilder);//シダ
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);//鉱石
        //BiomeDefaultFeatures.addExtraGold(biomeBuilder);//金


        BiomeDefaultFeatures.addForestGrass(biomeBuilder);//森の草
        //BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);//草
        //BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);//キノコ
// BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


        // 木
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacement.MAPLE_RED_TREE);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacement.MAPLE_ORANGE_TREE
        );

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacement.MAPLE_YELLOW_TREE
        );

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacement.MAPLE_FOREST_OAK_TREE
        );

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacement.MAPLE_FOREST_BROWN_MUSHROOM
        );

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacement.MAPLE_FOREST_RED_MUSHROOM
        );

        return new Biome.BiomeBuilder()
                // 雨が降るかどうか
                .hasPrecipitation(true)
                // 降水確率（沼地：0.9f 森林：0.8f）
                .downfall(0.5f)
                // 気温（森林：0.7f メサ：2.0f 雪タイガ：-0.5f）
                .temperature(0.3f)
                // 上の設定を読み込ませる
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                // その他の設定
                .specialEffects((new BiomeSpecialEffects.Builder())
                        // 水を冷たい藍色寄り
                        .waterColor(0x3A5F8A)
                        .waterFogColor(0x2A4A6A)

                        // 秋の青い空
                        .skyColor(0x5AA2F2)

                        // 草を黄緑～黄土寄り
                        .grassColorOverride(0xA89C4A)

                        // 葉色を橙寄り
                        .foliageColorOverride(0xC98A3A)

                        .fogColor(10854566)
                        //.ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.00625F))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                        .build())
                .build();
    }


}
