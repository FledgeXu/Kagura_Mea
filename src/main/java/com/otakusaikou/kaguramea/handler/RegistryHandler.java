package com.otakusaikou.kaguramea.handler;

import com.otakusaikou.kaguramea.entity.EntityMea;
import com.otakusaikou.kaguramea.init.ModItems;
import com.otakusaikou.kaguramea.interfaces.IHasModel;
import com.otakusaikou.kaguramea.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }
    @SubscribeEvent
    public static void onEntityEntryRegister(RegistryEvent.Register<EntityEntry> event){
        event.getRegistry().register(
                EntityEntryBuilder
                        .create()
                        .entity(EntityMea.class)
                        .id(new ResourceLocation(Reference.MODID + ":" + "mea"), 120)
                        .name("mea").egg(0xECC66C, 0x5898BF)
                        .tracker(64, 1, true)
                        .build()
        );
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for(Item item : ModItems.ITEMS){
            if(item instanceof IHasModel){
                ((IHasModel)item).registerModels();
            }
        }
    }

}
