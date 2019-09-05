package dev.aello.deathspawn.commands.deathspawn;

import dev.aello.deathspawn.DeathSpawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CreateCommand
{
    private static FileConfiguration config = DeathSpawn.getInstance().getConfig();

    public static void execute(CommandSender sender, String[] args)
    {
        if (!sender.hasPermission("deathspawn.admin"))
        {
            String noperms = ChatColor.translateAlternateColorCodes('&',
                    config.getString("lang.noperms"));
            sender.sendMessage(noperms);
            return;
        }

        String name = args[1].toLowerCase();

        if ((config.getConfigurationSection("spawns." + name) != null) || name.equals("admin"))
        {
            String alreadyexist = ChatColor.translateAlternateColorCodes('&',
                    config.getString("lang.alreadyexist"));
            sender.sendMessage(alreadyexist);

            return;
        }

        Location loc = ((Player) sender).getLocation();
        config.set("spawns." + name + ".loc", loc);

        String created = ChatColor.translateAlternateColorCodes('&',
                config.getString("lang.created"));

        sender.sendMessage(created);
    }
}
