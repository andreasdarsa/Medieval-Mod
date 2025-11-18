package net.andreasdarsa.medievalmod.entity;

import net.andreasdarsa.medievalmod.MedievalMod;
import net.andreasdarsa.medievalmod.entity.custom.DiamondThroneEntity;
import net.andreasdarsa.medievalmod.entity.custom.IronThroneEntity;
import net.andreasdarsa.medievalmod.entity.custom.WoodenThroneEntity;
import net.andreasdarsa.medievalmod.entity.custom.GoldenThroneEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, MedievalMod.MOD_ID);

    public static final Supplier<EntityType<WoodenThroneEntity>> WOODEN_THRONE_ENTITY =
            ENTITY_TYPES.register("wooden_throne_entity", ()->EntityType.Builder.of(WoodenThroneEntity::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("wooden_throne_entity"));

    public static final Supplier<EntityType<IronThroneEntity>> IRON_THRONE_ENTITY =
            ENTITY_TYPES.register("iron_throne_entity", ()->EntityType.Builder.of(IronThroneEntity::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("iron_throne_entity"));

    public static final Supplier<EntityType<GoldenThroneEntity>> GOLDEN_THRONE_ENTITY =
            ENTITY_TYPES.register("golden_throne_entity", ()->EntityType.Builder.of(GoldenThroneEntity::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("golden_throne_entity"));

    public static final Supplier<EntityType<DiamondThroneEntity>> DIAMOND_THRONE_ENTITY =
            ENTITY_TYPES.register("diamond_throne_entity", ()->EntityType.Builder.of(DiamondThroneEntity::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("diamond_throne_entity"));
}
