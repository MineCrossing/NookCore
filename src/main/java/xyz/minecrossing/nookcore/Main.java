package xyz.minecrossing.nookcore;

import co.aikar.commands.PaperCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.minecrossing.coreutilities.Logger;
import xyz.minecrossing.databaseconnector.DatabaseConnector;
import xyz.minecrossing.databaseconnector.DatabaseDetails;
import xyz.minecrossing.nookcore.commands.AddManyPlayersDataCommand;
import xyz.minecrossing.nookcore.commands.AddPlayerDataCommand;
import xyz.minecrossing.nookcore.commands.FlyCommand;
import xyz.minecrossing.nookcore.listeners.ChatListener;
import xyz.minecrossing.nookcore.listeners.WorldListener;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        Logger.info("We're live bois");

        registerEvents(new ChatListener(), new WorldListener());
        registerCommands();

        DatabaseConnector.getInstance().addDatabase(new DatabaseDetails(
                "127.0.0.1",
                3306,
                "minecrossing",
                "minecrossing",
                "JwdGCtfQMuazmTRTWgXQ2kZ3CdVzkSgG"
        ));
    }

    public static Main getInstance() {
        return instance;
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
        pcm.registerCommand(new AddPlayerDataCommand());
        pcm.registerCommand(new AddManyPlayersDataCommand());
    }

}
