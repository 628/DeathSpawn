package dev.aello.deathspawn.commands;

import dev.aello.deathspawn.commands.deathspawn.CreateCommand;
import dev.aello.deathspawn.commands.deathspawn.DeleteCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathspawnCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "You cannot use this from the console!");
            return true;
        }

        if (args.length != 2)
        {
            sender.sendMessage(ChatColor.RED + "Usage: /deathspawn <create/delete> <name>");
            return true;
        }

        // Sub-commands
        switch (args[0])
        {
            case "create":
            {
                CreateCommand.execute(sender, args);
                return true;
            }

            case "delete":
            {
                DeleteCommand.execute(sender, args);
                return true;
            }

            default:
            {
                sender.sendMessage(ChatColor.RED + "Usage: /deathspawn <create/delete> <name>");
                return true;
            }
        }
    }
}
