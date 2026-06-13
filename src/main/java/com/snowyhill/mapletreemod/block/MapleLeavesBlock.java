package com.snowyhill.mapletreemod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class MapleLeavesBlock extends LeavesBlock {
    private final Supplier<? extends ParticleOptions> particleSupplier;

    public MapleLeavesBlock(Supplier<? extends ParticleOptions> particleSupplier, Properties properties) {
        super(properties);
        this.particleSupplier = particleSupplier;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        if (random.nextInt(10) == 0) {
            BlockPos below = pos.below();

            if (level.isEmptyBlock(below)) {
                double x = pos.getX() + random.nextDouble();
                double y = pos.getY() - 0.05D;
                double z = pos.getZ() + random.nextDouble();

                level.addParticle(this.particleSupplier.get(), x, y, z, 0.0D, -0.02D, 0.0D);
            }
        }
    }
}