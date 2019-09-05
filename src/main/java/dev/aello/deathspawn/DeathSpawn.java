package dev.aello.deathspawn;

import dev.aello.deathspawn.commands.DeathspawnCommand;
import dev.aello.deathspawn.listeners.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

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

    @Override
    public void onDisable()
    {
        try
        {
            getConfig().save(new File(getDataFolder(), "config.yml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static DeathSpawn getInstance()
    {
        return instance;
    }
}
