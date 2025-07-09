package com.anthony.mobLevels;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class SpawnHandler implements Listener {
    private final LevelAssignment assignment = new LevelAssignment();

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event){
        assignment.assignLevelName(event.getEntity());
    }
}
