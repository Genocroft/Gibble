package com.genocraft.gibble.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;


public class CreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "gibble");

    public static final Supplier<CreativeModeTab> GIBBLE_ITEMS_TAB = CREATIVE_MODE_TAB.register("gibble_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GIBBLE_SPAWN_EGG.get()))
                    .title(Component.translatable("itemGroup.gibble.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GIBBLE_SPAWN_EGG.get());
                    }).build());

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TAB.register(eventBus);}
}
