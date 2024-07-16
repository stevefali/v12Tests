package com.example.examplemod.gamerules;

import net.minecraft.world.GameRules;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class MegaGameRules {

public static final String RULE_DO_BLOCK_RANDOM_DROPS = "doBlockRandomDrops";

    public static void register() {
        GameRules gameRules = FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld().getGameRules();

        if (!gameRules.hasRule(RULE_DO_BLOCK_RANDOM_DROPS)) {
            gameRules.addGameRule(RULE_DO_BLOCK_RANDOM_DROPS, "true", GameRules.ValueType.BOOLEAN_VALUE);
        }

    }

}
