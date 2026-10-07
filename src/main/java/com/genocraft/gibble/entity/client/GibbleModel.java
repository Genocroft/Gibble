package com.genocraft.gibble.entity.client;


import com.genocraft.gibble.entity.entity.GibbleEntity;
import com.genocraft.gibble.gibble;
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
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(gibble.MOD_ID, "gibble"), "main");
	private final ModelPart Gibble;
	private final ModelPart Torso;
	private final ModelPart Antenna;
	private final ModelPart Face;

	public GibbleModel(ModelPart root) {
		this.Gibble = root.getChild("Gibble");
		this.Torso = this.Gibble.getChild("Torso");
		this.Antenna = this.Gibble.getChild("Antenna");
		this.Face = this.Gibble.getChild("Face");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Gibble = partdefinition.addOrReplaceChild("Gibble", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = Gibble.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Antenna = Gibble.addOrReplaceChild("Antenna", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 21).addBox(-1.5F, -7.5F, -1.0F, 0.5F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 21).addBox(1.0F, -7.5F, -1.0F, 0.5F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 20).addBox(-0.5F, -8.5F, -0.5F, 1.0F, 0.5F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 16).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition cube_r1 = Antenna.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 21).addBox(-1.0F, -1.5F, -1.0F, 0.5F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -2.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = Antenna.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 22).addBox(-1.5F, -1.5F, -1.0F, 0.5F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Face = Gibble.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(12, 16).addBox(-1.0F, 1.42F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(14, 17).addBox(-2.0F, -2.58F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(16, 16).addBox(-2.0F, 0.42F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(12, 17).addBox(1.0F, 0.42F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(16, 17).addBox(1.0F, -2.58F, 0.0F, 1.5F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.42F, -4.1F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int colors) {
		Gibble.render(poseStack, vertexConsumer, packedLight, packedOverlay, colors);
	}

	@Override
	public ModelPart root() {
		return Gibble;
	}

	@Override
	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {

	}
}