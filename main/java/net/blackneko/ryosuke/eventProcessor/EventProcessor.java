package net.blackneko.ryosuke.eventProcessor;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class EventProcessor {
    boolean lightningStrike(Player player) {
        Location target;
        Entity targetEntity = player.getTargetEntity(50);
        if (targetEntity == null) {
            Block targetBlock = player.getTargetBlockExact(50);
            if (targetBlock == null) {
                return false;
            }
            target = targetBlock.getLocation();
        } else {
            target = targetEntity.getLocation();
        }
        player.getWorld().strikeLightning(target);
        return true;
    }

    public void onMagicWandSwung(Player player) {
        if (lightningStrike(player)) {
            player.sendMessage("lightning!");
        } else {
            player.sendMessage("failed!");
        }
    }
}
