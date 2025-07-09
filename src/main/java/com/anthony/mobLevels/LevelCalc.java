package com.anthony.mobLevels;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Wolf;
import org.bukkit.World;
import java.util.Random;

public class LevelCalc {
    private final LevelConfig config = new LevelConfig();
    private final Random rand = new Random();

    public int getMobLevel(Entity entity){
        boolean isHostile = entity instanceof Monster;
        boolean isNeutral = entity instanceof Wolf || entity instanceof Piglin;
        boolean isNether = entity.getWorld().getEnvironment() == World.Environment.NETHER;
        boolean isEnd = entity.getWorld().getEnvironment() == World.Environment.THE_END;

        int min, max;
        if(isHostile){
            min = config.hostileLevels[0];
            max = config.hostileLevels[1];
        } else if(isNeutral){
            min = config.neutralLevels[0];
            max = config.neutralLevels[1];
        } else{
            min = config.passiveLevels[0];
            max = config.passiveLevels[1];
        }

        if(isEnd){
            return ((rand.nextInt((max - min) + 1) + min) + config.getEndAdjustment());
        } else if (isNether){
            return ((rand.nextInt((max - min) + 1) + min) + config.getNetherAdjustment());
        } else{
            return rand.nextInt(max - min + 1) + min;
        }

    }


}
