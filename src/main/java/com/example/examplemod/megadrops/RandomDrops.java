package com.example.examplemod.megadrops;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.lwjgl.Sys;

import java.util.*;

public class RandomDrops {

    private static ArrayList<ItemStack> masterList;
    private static ArrayList<ItemStack> shuffledList;


    public static void shuffleItems(long gameSeed) {
//        Set<ResourceLocation> registeredItems = ForgeRegistries.ITEMS.getKeys();

        masterList = new ArrayList<>();

//        for (ResourceLocation registeredItem : registeredItems) {
//            if (!Arrays.asList(excludeItems).contains(registeredItem.toString())) {
//                masterList.add(ForgeRegistries.ITEMS.getValue(registeredItem));
//            }
//        }

        masterList.addAll(MegaItemRegistry.createItemList(excludeItems));

        System.out.println(masterList.size());

        shuffledList = new ArrayList<>(masterList);
        Collections.shuffle(shuffledList, new Random(gameSeed));
    }

    public static ItemStack getRandomizedItem(ItemStack vanillaItem) {

        ItemStack thing1 = Item.getItemById(425).getDefaultInstance();
        ItemStack thing2 = Item.getItemById(425).getDefaultInstance();
        ItemStack thing3 = Item.getItemById(425).getDefaultInstance();
        ItemStack thing4 = Item.getItemById(425).getDefaultInstance();
        ItemStack thing5 = Item.getItemById(355).getDefaultInstance();
        thing1.setItemDamage(10);
        thing2.setItemDamage(2);
        thing3.setItemDamage(10);

        System.out.println("areItemsEqual (1,2): " + ItemStack.areItemsEqual(thing1, thing2));
        System.out.println("areItemsEqual (1,3): " + ItemStack.areItemsEqual(thing1, thing3));
        System.out.println("areItemsEqual (1,4): " + ItemStack.areItemsEqual(thing1, thing4));
        System.out.println("areItemsEqual (1,5): " + ItemStack.areItemsEqual(thing1, thing5));
        System.out.println("areItemsEqual (4,5): " + ItemStack.areItemsEqual(thing4, thing5));

        if (masterList != null) {
            int index = getMasterListIndex(vanillaItem);

            System.out.print(vanillaItem.getDisplayName() + " " + index);

            if (index == -1) {
                return vanillaItem;
            } else {
                return shuffledList.get(index);
            }
        } else {
            return vanillaItem;
        }
    }

    private static int getMasterListIndex(ItemStack itemStack) {
            for (int i = 0; i < masterList.size(); i++)
                if (ItemStack.areItemsEqual(itemStack, masterList.get(i)))
                    return i;
        return -1;
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
