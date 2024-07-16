package com.example.examplemod.event;

import com.example.examplemod.gamerules.MegaGameRules;
import com.example.examplemod.megadrops.RandomDrops;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;


public class ServerEvents {

    @SubscribeEvent
    public void onBlockDrop(BlockEvent.HarvestDropsEvent event) {
//        String droppedItem = event.getDrops().size() > 0 ? event.getDrops().get(0).getDisplayName() : " Nothing";
//        System.out.println(droppedItem + " Was dropped!");
//        event.getDrops().add(new ItemStack(Blocks.DIAMOND_BLOCK));

        if (event.getWorld().getGameRules().getBoolean(MegaGameRules.RULE_DO_BLOCK_RANDOM_DROPS)) {
            ArrayList<ItemStack> randomizedDrops = new ArrayList<>();
            for (ItemStack vanillaDrop : event.getDrops()) {
                for (int i = 0; i < vanillaDrop.getCount(); i++) {
                    randomizedDrops.add(new ItemStack(RandomDrops.getRandomizedItem(vanillaDrop)));
                }
            }
            event.getDrops().clear();
            event.getDrops().addAll(randomizedDrops);
        }
    }


    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        World world = event.getEntity().getEntityWorld();
        Entity ent = event.getEntity();

        event.getDrops().add(new EntityItem(world, ent.posX, ent.posY, ent.posZ, new ItemStack(Blocks.GOLD_BLOCK)));
    }

}
