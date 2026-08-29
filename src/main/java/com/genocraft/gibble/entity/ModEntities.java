package com.genocraft.gibble.entity;

import com.genocraft.gibble.entity.custom.GibbleEntity;
import com.genocraft.gibble.gibble;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, gibble.MODID);

    //  Width and height have not been tested yet. Need to correct it.
    public static final Supplier<EntityType<GibbleEntity>> GIBBLE =
            ENTITY_TYPES.register("gibble", () -> EntityType.Builder.of(GibbleEntity::new, MobCategory.CREATURE)
                    .sized(8f, 8f).build("gibble"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register((eventBus));
    }
}
