package com.genocraft.gibble.entity.entity;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class GibbleEntity extends PathfinderMob {

    public GibbleEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1D));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.5D, stack -> stack.is(Items.COCOA_BEANS), false));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 5.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.ARMOR_TOUGHNESS,1D);
    }

    protected InteractionResult GibbleHealing(Player player, InteractionHand interaction) {
        ItemStack stack = player.getItemInHand(interaction);
            if (stack.is(Items.COCOA_BEANS)) {
                if (this.getHealth() < getMaxHealth()) {
                    this.heal(4.0F);
                }

                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }

            return super.mobInteract(player, interaction);
        }
}