package com.example.examplemod;

import com.example.examplemod.event.ClientEvents;
import com.example.examplemod.event.ServerEvents;
import com.example.examplemod.gamerules.MegaGameRules;
import com.example.examplemod.megadrops.RandomDrops;
import com.example.examplemod.networking.MegaMessages;
import com.example.examplemod.test.ItemTests;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@Mod(modid = V12Tests.MODID, name = V12Tests.NAME, version = V12Tests.VERSION, useMetadata = true)
public class V12Tests
{
    public static final String MODID = "v12tests";
    public static final String NAME = "Mega Randomizer 1.12.2 Tests";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        MinecraftForge.EVENT_BUS.register(new ServerEvents());
        MinecraftForge.EVENT_BUS.register(new ClientEvents());

        MegaMessages.register();
    }

    @EventHandler
    public void onServerReady(FMLServerStartedEvent event) {
//        ArrayList<Item> sampleList = new ArrayList<>(ForgeRegistries.ITEMS.getValuesCollection());
//        for (Item item : sampleList) {
//            System.out.println(item.getUnlocalizedName());
//        }
//        System.out.println("List size: " + sampleList.size());

//
//        ForgeRegistries.ITEMS.getKeys().forEach(item -> {
//            System.out.println(item.toString());
//        });

        MegaGameRules.register();

        RandomDrops.shuffleItems(FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld().getSeed());

        ItemTests.testAddingToList();
    }

}
