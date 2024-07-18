package com.example.examplemod.networking.packets;

import com.example.examplemod.gamerules.MegaGameRules;
import io.netty.buffer.ByteBuf;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SetGameRulesC2SPacket implements IMessage {

    private boolean isDoBlockRandomDrops;


    public SetGameRulesC2SPacket() {
    }

    public SetGameRulesC2SPacket(boolean isBlocks) {
        this.isDoBlockRandomDrops = isBlocks;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.isDoBlockRandomDrops = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(isDoBlockRandomDrops);
    }


    public static class Handler implements IMessageHandler<SetGameRulesC2SPacket, IMessage> {

        @Override
        public IMessage onMessage(SetGameRulesC2SPacket message, MessageContext ctx) {

            World world = ctx.getServerHandler().player.getEntityWorld();
            world.getGameRules().setOrCreateGameRule(MegaGameRules.RULE_DO_BLOCK_RANDOM_DROPS, String.valueOf(message.isDoBlockRandomDrops));

            return null;
        }
    }

}
