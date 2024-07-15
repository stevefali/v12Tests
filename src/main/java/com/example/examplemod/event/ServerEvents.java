package com.example.examplemod.event;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ServerEvents {

    @SubscribeEvent
    public void onBlockDrop(BlockEvent.HarvestDropsEvent event) {
        String droppedItem = event.getDrops().size() > 0 ? event.getDrops().get(0).getDisplayName() : " Nothing";
        System.out.println(droppedItem + " Was dropped!");
    }

}
