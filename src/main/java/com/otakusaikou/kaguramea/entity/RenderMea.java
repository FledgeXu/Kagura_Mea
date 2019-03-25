package com.otakusaikou.kaguramea.entity;

import com.otakusaikou.kaguramea.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMea extends RenderLiving<EntityMea> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID+":textures/entity/mea.png");
    public RenderMea(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMea(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMea entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityMea entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
