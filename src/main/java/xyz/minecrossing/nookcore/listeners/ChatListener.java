package xyz.minecrossing.nookcore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.minecrossing.coreutilities.Logger;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Logger.info(event.getPlayer().getName() + event.getMessage());
    }

}
