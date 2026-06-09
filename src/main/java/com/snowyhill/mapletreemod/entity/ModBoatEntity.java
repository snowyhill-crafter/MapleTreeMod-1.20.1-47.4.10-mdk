package com.snowyhill.mapletreemod.entity;

import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.registry.ModEntities;
import com.snowyhill.mapletreemod.registry.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.IntFunction;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    public ModBoatEntity(Level level, double x, double y, double z) {
        this(ModEntities.MOD_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case MAPLE -> ModItems.MAPLE_BOAT.get();

        };
    }

    public void setVariant(Type type) {
        this.entityData.set(DATA_ID_TYPE, type.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, Type.MAPLE.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("Type", getModVariant().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("Type", 8)) {
            this.setVariant(Type.byName(tag.getString("Type")));
        }
    }

    public enum Type {
        MAPLE(ModBlocks.MAPLE_PLANKS.get(), "maple");

        private final String name;
        private final Block planks;
        public static final IntFunction<Type> BY_ID = ByIdMap.continuous(Type::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        Type(Block planks, String name) {
            this.name = name;
            this.planks = planks;
        }

        public String getName() { return this.name; }
        public Block getPlanks() { return this.planks; }
        public static Type byId(int id) { return BY_ID.apply(id); }
        public static Type byName(String name) {
            for (Type type : values()) {
                if (type.name.equals(name)) return type;
            }
            return MAPLE;
        }
    }
}