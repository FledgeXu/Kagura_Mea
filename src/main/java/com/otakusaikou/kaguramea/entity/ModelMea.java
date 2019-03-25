package com.otakusaikou.kaguramea.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class ModelMea extends ModelBase {
    public ModelRenderer playerNeck;
    public ModelRenderer playerCenter;
    public ModelRenderer leftArmWear;
    public ModelRenderer rightLegWear;
    public ModelRenderer rightArmWear;
    public ModelRenderer playerHeadWear;
    public ModelRenderer leftLegWear;
    public ModelRenderer rightArm;
    public ModelRenderer rightLeg;
    public ModelRenderer playerHead;
    public ModelRenderer playerBody;
    public ModelRenderer leftArm;
    public ModelRenderer leftLeg;
    public ModelRenderer playerBodyWear;

    public ModelMea() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.leftArmWear = new ModelRenderer(this, 48, 48);
        this.leftArmWear.setRotationPoint(5.0F, 2.5F, 0.0F);
        this.leftArmWear.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.25F);
        this.playerNeck = new ModelRenderer(this, 24, 0);
        this.playerNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.playerNeck.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
        this.rightLeg = new ModelRenderer(this, 0, 16);
        this.rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.playerBody = new ModelRenderer(this, 16, 16);
        this.playerBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.playerBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.playerBodyWear = new ModelRenderer(this, 16, 32);
        this.playerBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.playerBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
        this.playerCenter = new ModelRenderer(this, 0, 0);
        this.playerCenter.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.playerCenter.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, 0.0F);
        this.playerHead = new ModelRenderer(this, 0, 0);
        this.playerHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.playerHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.rightArm = new ModelRenderer(this, 40, 16);
        this.rightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);
        this.rightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.rightArmWear = new ModelRenderer(this, 40, 32);
        this.rightArmWear.setRotationPoint(-5.0F, 2.5F, 0.0F);
        this.rightArmWear.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.25F);
        this.rightLegWear = new ModelRenderer(this, 0, 32);
        this.rightLegWear.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.rightLegWear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.playerHeadWear = new ModelRenderer(this, 32, 0);
        this.playerHeadWear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.playerHeadWear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.leftLegWear = new ModelRenderer(this, 0, 48);
        this.leftLegWear.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.leftLegWear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.leftArm = new ModelRenderer(this, 32, 48);
        this.leftArm.setRotationPoint(5.0F, 2.5F, 0.0F);
        this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.leftLeg = new ModelRenderer(this, 16, 48);
        this.leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.leftArmWear.render(f5);
        this.playerNeck.render(f5);
        this.rightLeg.render(f5);
        this.playerBody.render(f5);
        this.playerBodyWear.render(f5);
        this.playerCenter.render(f5);
        this.playerHead.render(f5);
        this.rightArm.render(f5);
        this.rightArmWear.render(f5);
        this.rightLegWear.render(f5);
        this.playerHeadWear.render(f5);
        this.leftLegWear.render(f5);
        this.leftArm.render(f5);
        this.leftLeg.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLegWear.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightLegWear.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightArmWear.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leftArmWear.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

        this.playerHead.rotateAngleY = netHeadYaw * 0.01745329F;
        this.playerHead.rotateAngleX = headPitch * -0.01745329F;
        this.playerHeadWear.rotateAngleY = netHeadYaw * 0.01745329F;
        this.playerHeadWear.rotateAngleX = headPitch * -0.01745329F;

    }
}

