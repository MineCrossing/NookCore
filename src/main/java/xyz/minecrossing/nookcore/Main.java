package xyz.minecrossing.nookcore;

import co.aikar.commands.PaperCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.minecrossing.coreutilities.Logger;
import xyz.minecrossing.nookcore.commands.FlyCommand;
import xyz.minecrossing.nookcore.listeners.ChatListener;
import xyz.minecrossing.nookcore.listeners.WorldListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger.info("We're live bois");

        registerEvents(new ChatListener(), new WorldListener());
        registerCommands();
    }

    private void registerEvents(Listener... listeners) {
        PluginManager pm = Bukkit.getPluginManager();
        for (Listener listener : listeners) {
            pm.registerEvents(listener, this);
        }
    }

    private void registerCommands() {
        PaperCommandManager pcm = new PaperCommandManager(this);
        pcm.registerCommand(new FlyCommand());
    }

}
