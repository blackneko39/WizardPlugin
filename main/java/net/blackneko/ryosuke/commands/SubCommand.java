package net.blackneko.ryosuke.commands;

import org.bukkit.command.CommandSender;

public interface SubCommand {
    boolean onCommand(CommandSender commandSender, String[] alias);
}
