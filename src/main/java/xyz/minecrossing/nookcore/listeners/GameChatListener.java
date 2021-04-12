package xyz.minecrossing.nookcore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.minecrossing.coreutilities.Logger;
import xyz.minecrossing.nookcore.Main;
import xyz.minecrossing.redisapi.RedisAPI;

/**
 * Listen for in-game chat messages and send it to redis to publish to Backend
 */
public class GameChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String result = event.getPlayer().getName() + ": " + event.getMessage();
        event.setFormat(result);
        Main.getInstance().getRedisConnection().publish("gameChat", result);
    }

}
