package com.example.examplemod.gui;

import com.example.examplemod.gamerules.MegaGameRules;
import com.example.examplemod.networking.MegaMessages;
import com.example.examplemod.networking.packets.SetGameRulesC2SPacket;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;


@SideOnly(Side.CLIENT)
public class ModPauseScreen extends GuiIngameMenu{


//    private final GuiIngameMenu normalMenu;

    public ModPauseScreen() {
//        this.normalMenu = normalMenu;
    }


    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.get(0).y = this.height / 4 + 144 - 16;
        this.buttonList.add(new GuiButton(14, this.width / 2 - 100, this.height / 4 + 120 + -16, "Mega Randomizer Options"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        if (button.id == 14) {
            System.out.println("Mega Randomizer Options button clicked!!");
            MegaMessages.sendToServer(new SetGameRulesC2SPacket(false));
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    public void drawScreen(int val_1, int val_2, float val_3) {
        super.drawScreen(val_1, val_2, val_3);
    }


}
