package com.genocraft.gibble.event;

import com.genocraft.gibble.entity.client.GibbleModel;
import com.genocraft.gibble.entity.entity.GibbleEntity;
import com.genocraft.gibble.entity.entity.ModEntities;
import com.genocraft.gibble.gibble;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = gibble.MOD_ID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GibbleModel.LAYER_LOCATION, GibbleModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GIBBLE.get(), GibbleEntity.createAttributes().build());
    }
}
