package com.otakusaikou.kaguramea.items;

import com.otakusaikou.kaguramea.helper.ItemInitializeHelper;
import com.otakusaikou.kaguramea.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SuperChat extends Item implements IHasModel {
    public SuperChat(String name) {
        ItemInitializeHelper.initHelper(this,name, CreativeTabs.MATERIALS);
    }

    @Override
    public void registerModels() {
        ItemInitializeHelper.modelRegisterHelper(this);
    }
}
