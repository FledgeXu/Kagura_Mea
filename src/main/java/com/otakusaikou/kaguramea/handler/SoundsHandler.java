package com.otakusaikou.kaguramea.handler;

import com.otakusaikou.kaguramea.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


public class SoundsHandler {
    public static SoundEvent ENTITY_MEA_PLEASE_GIVE_ME_MONEY, ENTITY_MEA_SCREAM, ENTITY_MEA_THANKS, ENTITY_MEA_DEATH;

    public static void registerSounds() {
        ENTITY_MEA_PLEASE_GIVE_ME_MONEY = registerSound("entity.mea.please_give_me_money");
        ENTITY_MEA_SCREAM = registerSound("entity.mea.scream");
        ENTITY_MEA_THANKS = registerSound("entity.mea.thanks");
        ENTITY_MEA_DEATH = registerSound("entity.mea.death");
    }

    private static SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
