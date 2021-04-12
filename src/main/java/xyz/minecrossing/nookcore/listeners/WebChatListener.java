package xyz.minecrossing.nookcore.listeners;

import org.bukkit.Bukkit;
import xyz.minecrossing.redisapi.redis.RedisChannelListener;

/**
 * Broadcast messages received from Redis (Backend) to the in-game chat
 */
public class WebChatListener implements RedisChannelListener {

    @Override
    public void messageReceived(String message) {
        Bukkit.broadcastMessage(message);
    }
}
