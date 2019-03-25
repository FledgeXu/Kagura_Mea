package com.otakusaikou.kaguramea;

import com.otakusaikou.kaguramea.handler.RenderHandler;
import com.otakusaikou.kaguramea.handler.SoundsHandler;
import com.otakusaikou.kaguramea.proxy.CommonProxy;
import com.otakusaikou.kaguramea.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(version = Reference.VERSION, modid = Reference.MODID, name = Reference.NAME)
public class Main {
    @Mod.Instance()
    public static Main INSTANCE = new Main();
    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy PROXY;
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        RenderHandler.registerEntityRenders();
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        SoundsHandler.registerSounds();
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){

    }
}
