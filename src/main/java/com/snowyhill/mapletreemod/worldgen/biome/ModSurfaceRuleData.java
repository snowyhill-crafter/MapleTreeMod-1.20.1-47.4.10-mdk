package com.snowyhill.mapletreemod.worldgen.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRuleData {
/*
    private static final SurfaceRules.RuleSource GLASS = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource ORIHALCON =
            makeStateRule(ModBlocks.ORIHALCON_BLOCK.get());

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                // 呪われた森バイオームの地面を泥ブロックにする
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(IntroductionBiomes.CURSED_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, MUD)),
                // 呪われた森バイオームの天井をオリハルコンブロックにする
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(IntroductionBiomes.CURSED_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, ORIHALCON))
        );
    }

 */

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

}
