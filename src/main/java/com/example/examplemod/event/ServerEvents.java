package com.example.examplemod.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ServerEvents {

    @SubscribeEvent
    public void onBlockDrop(BlockEvent.HarvestDropsEvent event) {
        String droppedItem = event.getDrops().size() > 0 ? event.getDrops().get(0).getDisplayName() : " Nothing";
        System.out.println(droppedItem + " Was dropped!");
        event.getDrops().add(new ItemStack(Blocks.DIAMOND_BLOCK));
    }


    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        World world = event.getEntity().getEntityWorld();
        Entity ent = event.getEntity();

        event.getDrops().add(new EntityItem(world, ent.posX, ent.posY, ent.posZ, new ItemStack(Blocks.GOLD_BLOCK)));

    }

}
