package net.blackneko.ryosuke.eventHandler;

import net.blackneko.ryosuke.eventProcessor.EventProcessor;
import net.blackneko.ryosuke.items.MagicWand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventManager implements Listener {
    private final EventProcessor eventProcessor = new EventProcessor();

    boolean wasMagicWandSwung(Action action, ItemStack havingItem) {
        if (!action.isRightClick()) return false;
        if (havingItem == null) return false;

        MagicWand magicWand = new MagicWand();
        return havingItem.displayName().toString().equals(magicWand.displayName().toString());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if ( wasMagicWandSwung(e.getAction(), e.getItem()) ) {
            eventProcessor.onMagicWandSwung(e.getPlayer());
        }
    }

}
