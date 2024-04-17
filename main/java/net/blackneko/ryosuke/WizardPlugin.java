package net.blackneko.ryosuke;

import net.blackneko.ryosuke.commands.CommandManager;
import net.blackneko.ryosuke.eventHandler.EventManager;
import net.blackneko.ryosuke.wizard.WizardManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class WizardPlugin extends JavaPlugin {
    static public WizardPlugin plugin;
    final private EventManager eventManager = new EventManager();
    final private CommandManager commandManager = new CommandManager();
    final private static WizardManager wizardManager = new WizardManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(eventManager, this);
        getCommand("bnek").setExecutor(commandManager);
        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
