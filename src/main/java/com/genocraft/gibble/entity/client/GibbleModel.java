package com.genocraft.gibble.entity.client;

import com.genocraft.gibble.entity.entity.GibbleEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class GibbleModel<T extends GibbleEntity> extends HierarchicalModel<T> {
        // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("gibble", "gibble"), "main");
        private final ModelPart gibble;
        private final ModelPart head;

        public GibbleModel(ModelPart root) {
            this.gibble = root.getChild("Gibble");
            this.head = this.gibble.getChild("Head");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition Gibble = partdefinition.addOrReplaceChild("Gibble", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

            PartDefinition Torso = Gibble.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

            PartDefinition Head = Gibble.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(8, 16).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

            PartDefinition Antenna = Gibble.addOrReplaceChild("Antenna", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

            PartDefinition Face = Gibble.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(12, 18).addBox(-1.0F, -2.0F, 4.1F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                    .texOffs(12, 16).addBox(1.0F, -7.0F, 4.1F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                    .texOffs(16, 16).addBox(-3.0F, -7.0F, 4.1F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                    .texOffs(16, 18).addBox(-2.0F, -3.0F, 4.1F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                    .texOffs(18, 18).addBox(1.0F, -3.0F, 4.1F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

            return LayerDefinition.create(meshdefinition, 32, 32);
        }

        @Override
        public void setupAnim(GibbleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
            gibble.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }

        @Override
        public ModelPart root() {
            return gibble;
        }
}
