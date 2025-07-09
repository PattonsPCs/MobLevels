package com.anthony.mobLevels;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Wolf;

public class LevelAssignment {
    private final LevelCalc calc = new  LevelCalc();
    private static final MiniMessage MM = MiniMessage.miniMessage();

    public void assignLevelName(Entity entity){
        int level = calc.getMobLevel(entity);
        Component category;


        if(entity instanceof Wolf || entity instanceof Piglin){
            category = mm("<gold>[Neutral]</gold>");
        } else if(entity instanceof Monster){
            category = mm("<red>[Hostile]</red>");
        } else {
            category = mm("<green>[Passive]</green>");
        }

        Component customName = category.append(Component.text(" Lv." + level + " " + entity.getName()));
        entity.customName(customName);
        entity.setCustomNameVisible(true);
    }

    public static Component mm(String msg){
        return MM.deserialize(msg);
    }





}
