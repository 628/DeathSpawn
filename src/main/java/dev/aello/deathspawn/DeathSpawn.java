package dev.aello.deathspawn;

import dev.aello.deathspawn.commands.DeathspawnCommand;
import dev.aello.deathspawn.listeners.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathSpawn extends JavaPlugin
{
    private static DeathSpawn instance;

    @Override
    public void onEnable()
    {
        instance = this;
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new DeathListener(), this);

        getCommand("deathspawn").setExecutor(new DeathspawnCommand());
    }

    public static DeathSpawn getInstance()
    {
        return instance;
    }
}
