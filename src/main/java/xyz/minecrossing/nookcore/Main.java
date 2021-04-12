package xyz.minecrossing.nookcore;

import co.aikar.commands.PaperCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;
import xyz.minecrossing.coreutilities.Logger;
import xyz.minecrossing.nookcore.commands.AddManyPlayersDataCommand;
import xyz.minecrossing.nookcore.commands.AddPlayerDataCommand;
import xyz.minecrossing.nookcore.commands.FlyCommand;
import xyz.minecrossing.nookcore.listeners.GameChatListener;
import xyz.minecrossing.nookcore.listeners.WebChatListener;
import xyz.minecrossing.nookcore.listeners.WorldListener;
import xyz.minecrossing.nookcore.utils.ChatGenerator;
import xyz.minecrossing.redisapi.RedisAPI;
import xyz.minecrossing.redisapi.redis.RedisConnector;

public class Main extends JavaPlugin {

    private static Main instance;

    private Jedis redisConnection;

    @Override
    public void onEnable() {
        instance = this;

        Logger.info("We're live bois");

        registerEvents(new GameChatListener(), new WorldListener());
        registerCommands();

        // Create and initialise the redis connection listening to the web chat
        RedisAPI redisAPI = RedisAPI.getRedisAPI();
        redisAPI.initialize();

        RedisConnector redisConnector = redisAPI.getRedisConnector();
        redisConnector.listenForChannel("webChat", new WebChatListener());

        redisConnection = redisConnector.getConnection();

        // Start chat generator with random intervals
        ChatGenerator generator = new ChatGenerator();
        generator.runTaskTimer(this, 0, generator.getTime());
    }

    @Override
    public void onDisable() {
        RedisAPI redisAPI = RedisAPI.getRedisAPI();
        redisAPI.shutdown();
    }

    public static Main getInstance() {
        return instance;
    }

    public Jedis getRedisConnection() {
        return redisConnection;
    }

    /**
     * Register listeners to hook into Bukkit events
     *
     * @param listeners The list of listeners to register
     */
    private void registerEvents(Listener... listeners) {
        PluginManager pm = Bukkit.getPluginManager();
        for (Listener listener : listeners) {
            pm.registerEvents(listener, this);
        }
    }

    /**
     * Register user commands with the paper command manager
     * for better async auto completion.
     */
    private void registerCommands() {
        PaperCommandManager pcm = new PaperCommandManager(this);
        pcm.registerCommand(new FlyCommand());
        pcm.registerCommand(new AddPlayerDataCommand());
        pcm.registerCommand(new AddManyPlayersDataCommand());
    }

}
