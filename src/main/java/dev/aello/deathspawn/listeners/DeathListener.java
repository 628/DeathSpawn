package dev.aello.deathspawn.listeners;

import dev.aello.deathspawn.DeathSpawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListener implements Listener
{
    private static FileConfiguration config = DeathSpawn.getInstance().getConfig();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeath(PlayerRespawnEvent event)
    {
        ConfigurationSection spawns = config.getConfigurationSection("spawns");

        if (spawns == null)
        {
            return;
        }

        for (String s : spawns.getKeys(false))
        {
            String permission = "deathspawn." + s.toLowerCase();

            if (event.getPlayer().hasPermission(permission))
            {
                Location loc = (Location) spawns.get(s + ".loc");
                System.out.println(loc);

                event.setRespawnLocation(loc);

                String message = ChatColor.translateAlternateColorCodes('&',
                        config.getString("lang.teleported").replace("{SPAWN_NAME}", s.toLowerCase()));
                event.getPlayer().sendMessage(message);

                break;
            }
        }
    }
}
