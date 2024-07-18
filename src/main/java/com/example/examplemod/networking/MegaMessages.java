package com.example.examplemod.networking;

import com.example.examplemod.V12Tests;
import com.example.examplemod.networking.packets.SetGameRulesC2SPacket;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class MegaMessages {

    private static SimpleNetworkWrapper INSTANCE;

    private static int packetId = 0;

    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleNetworkWrapper networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(V12Tests.MODID);
        INSTANCE = networkWrapper;

        /* To Server */
        networkWrapper.registerMessage(SetGameRulesC2SPacket.Handler.class, SetGameRulesC2SPacket.class, id(), Side.SERVER);
    }


    public static void sendToServer(IMessage message) {
        INSTANCE.sendToServer(message);
    }

}
