package com.otakusaikou.kaguramea.items.foods;

import com.otakusaikou.kaguramea.helper.ItemInitializeHelper;
import com.otakusaikou.kaguramea.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;


public class StrawberryMilk extends ItemFood implements IHasModel {
    PotionEffect[] effects;

    public StrawberryMilk(String name, PotionEffect[] effects, int amount, float saturation) {
        super(amount, saturation, false);
        ItemInitializeHelper.initHelper(this, name, CreativeTabs.FOOD);
        this.effects = effects;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer) entityLiving : null;
        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (entityplayer != null) {
                entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public void registerModels() {
        ItemInitializeHelper.modelRegisterHelper(this);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            for (PotionEffect effect : effects) {
                player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles()));
            }
        }
    }

    @SideOnly(CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
