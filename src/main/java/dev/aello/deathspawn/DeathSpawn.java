package dev.aello.deathspawn;

import org.bukkit.plugin.java.JavaPlugin;

public class DeathSpawn extends JavaPlugin
{
    private static DeathSpawn instance;

    @Override
    public void onEnable()
    {
        instance = this;
        saveDefaultConfig();
    }

    public static DeathSpawn getInstance()
    {
        return instance;
    }
}
