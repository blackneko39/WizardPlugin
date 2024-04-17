package net.blackneko.ryosuke.items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MagicWand extends ItemStack {
    final String NAME = "Magic Wand";
    final Color NAME_COLOR = Color.PURPLE;
    final TextDecoration NAME_DECORATION = TextDecoration.BOLD;

    public MagicWand() {
        super(Material.STICK);
        ItemMeta meta = this.getItemMeta();
        meta.displayName(getComponent());
        this.setItemMeta(meta);
        this.getItemFlags().add(ItemFlag.HIDE_ENCHANTS);
    }

    Component getComponent() {
        return Component.text(NAME).color(TextColor.color(NAME_COLOR.asRGB())).decorate(NAME_DECORATION);
    }
}
