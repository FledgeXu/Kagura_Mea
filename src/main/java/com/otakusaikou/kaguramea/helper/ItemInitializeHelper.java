package com.otakusaikou.kaguramea.helper;

import com.otakusaikou.kaguramea.Main;
import com.otakusaikou.kaguramea.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemInitializeHelper {
    public static void initHelper(Item item, String name, CreativeTabs tab){
        item.setUnlocalizedName(name);
        item.setRegistryName(name);
        item.setCreativeTab(tab);
        ModItems.ITEMS.add(item);
    }
    public static void modelRegisterHelper(Item item){
        Main.PROXY.registerItemRenderer(item, 0, "inventory");
    }
}
