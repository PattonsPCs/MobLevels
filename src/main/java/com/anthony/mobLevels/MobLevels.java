package com.anthony.mobLevels;

import org.bukkit.plugin.java.JavaPlugin;


public final class MobLevels extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("MobLevels Enabled!");

        getServer().getPluginManager().registerEvents(new SpawnHandler(), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("MobLevels Disabled!");
    }
}
