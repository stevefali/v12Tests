package com.example.examplemod.megadrops;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.*;

public class RandomDrops {

    private static ArrayList<Item> masterList;

    private static ArrayList<Item> shuffledList;


    public static void shuffleItems(long gameSeed) {
        Set<ResourceLocation> registeredItems = ForgeRegistries.ITEMS.getKeys();

        masterList = new ArrayList<>();

        for (ResourceLocation registeredItem : registeredItems) {
            if (!Arrays.asList(excludeItems).contains(registeredItem.toString())) {
                masterList.add(ForgeRegistries.ITEMS.getValue(registeredItem));
            }
        }

        shuffledList = new ArrayList<>(masterList);
        Collections.shuffle(shuffledList, new Random(gameSeed));
    }



    private static final String[] excludeItems = {
            "minecraft:structure_block",
            "minecraft:structure_void",
            "minecraft:chain_command_block",
            "minecraft:air",
            "minecraft:bedrock",
            "minecraft:command_block_minecart",
            "minecraft:spawn_egg",
            "minecraft:command_block",
            "minecraft:mob_spawner",
            "minecraft:repeating_command_block",
            "minecraft:barrier",
            "minecraft:end_portal_frame"
    };
}
