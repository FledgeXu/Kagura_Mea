package com.otakusaikou.kaguramea.entity;

import com.otakusaikou.kaguramea.handler.SoundsHandler;
import com.otakusaikou.kaguramea.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMea extends EntityAnimal {
    public EntityMea(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 1.4F);
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.GLASS_BOTTLE && !player.capabilities.isCreativeMode) {
            player.playSound(SoundEvents.ITEM_BOTTLE_FILL, 1.0F, 1.0F);
            itemstack.shrink(1);

            if (itemstack.isEmpty()) {
                player.setHeldItem(hand, new ItemStack(ModItems.STRAWBERRY_MILK));
            } else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.STRAWBERRY_MILK))) {
                player.dropItem(new ItemStack(ModItems.STRAWBERRY_MILK), false);
            }

            return true;
        }
        if (itemstack.getItem() == ModItems.SUPERCHAT) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.spawnParticle(EnumParticleTypes.HEART, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
            this.playSound(SoundsHandler.ENTITY_MEA_THANKS,1.0F, 1.0F);
            return true;
        }
        return false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ModItems.SUPERCHAT, false));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    public void playSound(SoundEvent soundIn, float volume, float pitch)
    {
        if (!this.isSilent())
        {
            this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, soundIn, this.getSoundCategory(), volume, pitch);
        }
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ModItems.STRAWBERRY_MILK;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundsHandler.ENTITY_MEA_PLEASE_GIVE_ME_MONEY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundsHandler.ENTITY_MEA_SCREAM;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundsHandler.ENTITY_MEA_DEATH;
    }

    @Override
    public EntityCow createChild(EntityAgeable ageable) {
        return null;
    }
}
