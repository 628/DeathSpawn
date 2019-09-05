package dev.aello.deathspawn.commands.deathspawn;

import dev.aello.deathspawn.DeathSpawn;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class DeleteCommand
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

        if ((config.getConfigurationSection("spawns." + name) == null))
        {
            String noexist = ChatColor.translateAlternateColorCodes('&',
                    config.getString("lang.noexist"));
            sender.sendMessage(noexist);

            return;
        }

        config.set("spawns." + name, null);

        String deleted = ChatColor.translateAlternateColorCodes('&',
                config.getString("lang.deleted"));

        sender.sendMessage(deleted);
    }
}
