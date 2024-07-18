package com.example.examplemod.event;

import com.example.examplemod.gui.ModPauseScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientEvents {

    @SubscribeEvent
    public void onPauseMenuTriggered(GuiScreenEvent event) {
        if (event.getGui() instanceof GuiIngameMenu && !(event.getGui() instanceof ModPauseScreen)) {
//            Minecraft.getMinecraft().displayGuiScreen(new ModPauseScreen((GuiIngameMenu) event.getGui()));
            Minecraft.getMinecraft().displayGuiScreen(new ModPauseScreen());
        }
    }

}
