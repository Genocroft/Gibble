package com.genocraft.gibble.entity.client;

import com.genocraft.gibble.entity.entity.GibbleEntity;
import com.genocraft.gibble.gibble;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GibbleRenderer extends MobRenderer<GibbleEntity, GibbleModel<GibbleEntity>> {
    public GibbleRenderer(EntityRendererProvider.Context context) {
        super(context, new GibbleModel<>(context.bakeLayer(GibbleModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(GibbleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(gibble.MOD_ID, "textures/entities/item/gibble_texture.png");
    }

    @Override
    public void render(GibbleEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            poseStack.scale(1.0f, 1.0f, 1.0f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}