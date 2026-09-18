package com.genocraft.gibble.item;

import com.genocraft.gibble.entity.entity.ModEntities;
import com.genocraft.gibble.gibble;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(gibble.MOD_ID);

    public static final DeferredItem<Item> GIBBLE_SPAWN_EGG = ITEMS.register("gibble spawn egg",
            () -> new DeferredSpawnEggItem(ModEntities.GIBBLE, 0x31afaf, 0xffac00,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
