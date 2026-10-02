package com.genocraft.gibble.item;

import com.genocraft.gibble.entity.entity.ModEntities;
import com.genocraft.gibble.gibble;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(gibble.MOD_ID);

    public static final DeferredItem<SpawnEggItem> GIBBLE_SPAWN_EGG =
            ITEMS.register("gibble_spawn_egg", () -> new SpawnEggItem(
                    ModEntities.GIBBLE.get(), 0xFFFFF, 0x00000, new Item.Properties()));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
