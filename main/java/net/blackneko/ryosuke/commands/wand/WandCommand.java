package net.blackneko.ryosuke.commands.wand;

import net.blackneko.ryosuke.commands.SubCommand;
import net.blackneko.ryosuke.items.MagicWand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WandCommand implements SubCommand {
    final String root = "wand";

    @Override
    public boolean onCommand(CommandSender commandSender, String[] alias) {
        if (!(commandSender instanceof Player player)) return false;
        player.getInventory().addItem(new MagicWand());
        return true;
    }
}
