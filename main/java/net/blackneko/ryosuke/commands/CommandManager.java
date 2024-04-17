package net.blackneko.ryosuke.commands;

import net.blackneko.ryosuke.commands.wand.WandCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class CommandManager implements CommandExecutor {
    final Map<String, SubCommand> commandsMap;
    final String root = "bnek";

    public CommandManager() {
        commandsMap = new HashMap<>();
        commandsMap.put("wand", new WandCommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String thisName = command.getName();

        if (thisName.equals(root)) {
            if (strings.length > 0) {
                String nextName = strings[0];
                if (commandsMap.containsKey(nextName)) {
                    SubCommand nextCommand = commandsMap.get(nextName);

                    return nextCommand.onCommand(commandSender, strings);
                }
            }
        }
        return false;
    }
}
