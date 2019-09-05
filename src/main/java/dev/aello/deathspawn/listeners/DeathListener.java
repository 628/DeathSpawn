package dev.aello.deathspawn.listeners;

import dev.aello.deathspawn.DeathSpawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener
{
    private static FileConfiguration config = DeathSpawn.getInstance().getConfig();

    @EventHandler
    public void onDeath(PlayerDeathEvent event)
    {
        ConfigurationSection spawns = config.getConfigurationSection("spawns");

        for (String s : spawns.getKeys(false))
        {
            String permission = "deathspawn." + s.toLowerCase();

            if (event.getEntity().hasPermission(permission))
            {
                Location loc = (Location) spawns.get(s + ".loc");
                event.getEntity().teleport(loc);

                String message = ChatColor.translateAlternateColorCodes('&',
                        config.getString("lang.teleported"));
                event.getEntity().sendMessage(message);

                break;
            }
        }
    }
}
