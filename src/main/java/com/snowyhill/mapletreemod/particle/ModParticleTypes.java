package com.snowyhill.mapletreemod.particle;

import com.snowyhill.mapletreemod.MapleTreeMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticleTypes {

    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MapleTreeMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> MAPLE_RED_LEAF =
            PARTICLES.register("maple_red_leaf",
                    () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> MAPLE_ORANGE_LEAF =
            PARTICLES.register("maple_orange_leaf",
                    () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> MAPLE_YELLOW_LEAF =
            PARTICLES.register("maple_yellow_leaf",
                    () -> new SimpleParticleType(false));

}