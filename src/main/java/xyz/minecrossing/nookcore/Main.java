package xyz.minecrossing.nookcore;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.minecrossing.nookcore.listeners.ChatListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("We're live bois");

        registerEvents(new ChatListener());
    }

    private void registerEvents(Listener... listeners) {
        PluginManager pm = Bukkit.getPluginManager();
        for (Listener listener : listeners) {
            pm.registerEvents(listener, this);
        }
    }

}
