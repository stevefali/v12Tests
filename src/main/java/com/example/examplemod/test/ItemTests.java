package com.example.examplemod.test;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.lwjgl.Sys;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ItemTests {

    private static String sp = ", ";

    public static void testItemRegistry() {

        ItemStack otherVersion = new ItemStack(Blocks.LOG);
        otherVersion.setItemDamage(3);
        System.out.println(otherVersion.getDisplayName());

        System.out.println("********* Steve's Tests **********************");
        ForgeRegistries.ITEMS.getEntries().forEach(registryItem -> {
            String info = registryItem.getValue().getHasSubtypes() + sp + registryItem.getValue().getDefaultInstance().getDisplayName() + sp + registryItem.getValue().getDefaultInstance().getItemDamage();
            System.out.println(info);
        });
        System.out.println("ForgeRegistry.ITEMS size: " + ForgeRegistries.ITEMS.getEntries().size());
//        testAddingToList();
    }


    private static final Map<Integer, Integer> subtypeQuantities = createSubtypeQuantities();

    public static void testAddingToList() {
        ItemStack banner = Item.getItemById(425).getDefaultInstance();
        banner.setItemDamage(10);
        System.out.println(banner.getDisplayName() + " " + Item.getIdFromItem(banner.getItem()));


        ArrayList<ItemStack> allItems = new ArrayList<>();

        ForgeRegistries.ITEMS.getEntries().forEach(registryItem -> {
            if (!Arrays.asList(excludeItems).contains(registryItem.getKey().toString())) {
                if (!registryItem.getValue().getHasSubtypes()) {
                    allItems.add(registryItem.getValue().getDefaultInstance());
                } else {
                    if (!allItems.contains(registryItem.getValue().getDefaultInstance())) {
                        int itemId = Item.getIdFromItem(registryItem.getValue());
                        if (subtypeQuantities.containsKey(itemId)) {
                            // Add all subtypes
                            int subtypeQuantity = subtypeQuantities.get(itemId);
                            for (int i = 0; i < subtypeQuantity; i++) {
                                ItemStack subtype = Item.getItemById(itemId).getDefaultInstance();
                                subtype.setItemDamage(i);
                                allItems.add(subtype);
                            }
                        } else {
                            // Just add the one
                            allItems.add(registryItem.getValue().getDefaultInstance());
                        }
                    }

                }
            }

        });

        for (ItemStack item : allItems) {
            System.out.println(item.getDisplayName());
        }
        System.out.println("Total number of items: " + allItems.size());

    }

    private static Map<Integer, Integer> createSubtypeQuantities() {
        Map<Integer, Integer> subtypeQuantities = new HashMap<>();
        subtypeQuantities.put(1, 7);
        subtypeQuantities.put(322, 2);
        subtypeQuantities.put(3, 3);
        subtypeQuantities.put(5, 6);
        subtypeQuantities.put(6, 6);
        subtypeQuantities.put(263, 2);
        subtypeQuantities.put(139, 2);
        subtypeQuantities.put(12, 2);
        subtypeQuantities.put(397, 6);
        subtypeQuantities.put(145, 3);
        subtypeQuantities.put(17, 4);
        subtypeQuantities.put(18, 4);
        subtypeQuantities.put(19, 2);
        subtypeQuantities.put(24, 3);
        subtypeQuantities.put(155, 3);
        subtypeQuantities.put(349, 4);
        subtypeQuantities.put(350, 2);
        subtypeQuantities.put(351, 16);
        subtypeQuantities.put(95, 16);
        subtypeQuantities.put(159, 16);
        subtypeQuantities.put(31, 2);
        subtypeQuantities.put(160, 16);
        subtypeQuantities.put(161, 2);
        subtypeQuantities.put(97, 6);
        subtypeQuantities.put(162, 2);
        subtypeQuantities.put(98, 4);
        subtypeQuantities.put(355, 16);
        subtypeQuantities.put(35, 16);
        subtypeQuantities.put(38, 9);
        subtypeQuantities.put(168, 3);
        subtypeQuantities.put(425, 16);
        subtypeQuantities.put(171, 16);
        subtypeQuantities.put(44, 7);
        subtypeQuantities.put(175, 6);
        subtypeQuantities.put(179, 3);
        subtypeQuantities.put(251, 16);
        subtypeQuantities.put(252, 16);
        subtypeQuantities.put(126, 6);

        return subtypeQuantities;
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
