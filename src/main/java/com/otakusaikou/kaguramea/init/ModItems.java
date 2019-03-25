package com.otakusaikou.kaguramea.init;

import com.otakusaikou.kaguramea.items.SuperChat;
import com.otakusaikou.kaguramea.items.foods.StrawberryMilk;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static List<Item> ITEMS = new ArrayList<>();
    public static Item STRAWBERRY_MILK = new StrawberryMilk(
            "strawberry_milk",
            new PotionEffect[]{
                    new PotionEffect(MobEffects.WITHER, 60 * 3, 1),
                    new PotionEffect(MobEffects.NAUSEA, 60 * 10, 3)
            },
            20,
            20F
    );
    public static Item SUPERCHAT = new SuperChat("superchat");
}
