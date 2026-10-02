// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
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
	private final ModelPart Eyes;
	private final ModelPart Mouth;

	public GibbleModel(ModelPart root) {
		this.Gibble = root.getChild("Gibble");
		this.Torso = this.Gibble.getChild("Torso");
		this.Antenna = this.Gibble.getChild("Antenna");
		this.Face = this.Gibble.getChild("Face");
		this.Eyes = this.Face.getChild("Eyes");
		this.Mouth = this.Face.getChild("Mouth");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Gibble = partdefinition.addOrReplaceChild("Gibble", CubeListBuilder.create(), PartPose.offset(0.0F, 17.9722F, 1.6333F));

		PartDefinition Torso = Gibble.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0278F, -1.3667F));

		PartDefinition Antenna = Gibble.addOrReplaceChild("Antenna", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 16).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.9722F, -1.3667F));

		PartDefinition Face = Gibble.addOrReplaceChild("Face", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.9444F, -5.4333F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Eyes = Face.addOrReplaceChild("Eyes", CubeListBuilder.create().texOffs(12, 16).addBox(1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(16, 16).addBox(-3.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.9167F, 0.0333F));

		PartDefinition Mouth = Face.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(12, 18).addBox(-1.0F, 0.1667F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(16, 18).addBox(-2.0F, -0.8333F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(18, 18).addBox(1.0F, -0.8333F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.9167F, 0.0333F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(GibbleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Gibble.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return Gibble;
	}
}