package com.otakusaikou.kaguramea.handler;

import com.otakusaikou.kaguramea.entity.EntityMea;
import com.otakusaikou.kaguramea.entity.RenderMea;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityMea.class, new IRenderFactory<EntityMea>() {
            @Override
            public Render<? super EntityMea> createRenderFor(RenderManager manager) {
                return new RenderMea(manager);
            }
        });
    }
}
