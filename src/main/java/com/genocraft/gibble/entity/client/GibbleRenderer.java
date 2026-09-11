package com.genocraft.gibble.entity.client;

import com.genocraft.gibble.entity.entity.GibbleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GibbleRenderer extends MobRenderer
        <GibbleEntity, GibbleModel<GibbleEntity>> {

    public GibbleRenderer(EntityRendererProvider.Context context) {
        super(context, new GibbleModel(context.bakeLayer()), 0.5F
        );
    }

    public static void register(Object o) {

    }

    @Override
    public ResourceLocation getTextureLocation(GibbleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("gibble", "textures/entity/gibble-texture.png");
    }
}
