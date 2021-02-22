package xyz.minecrossing.nookcore.listeners;

import org.bukkit.Bukkit;
import xyz.minecrossing.redisapi.redis.RedisChannelListener;

public class WebChatListener implements RedisChannelListener {

    @Override
    public void messageReceived(String message) {
        Bukkit.broadcastMessage(message);
    }
}
