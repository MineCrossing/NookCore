package xyz.minecrossing.nookcore.utils;

import org.bukkit.ChatColor;

public class Text {

    /**
     * Translate a message using '&' into Minecraft coloured message using '§'
     *
     * @param msg The message to colour
     * @return The coloured message with old symbols replaced
     */
    public static String colour(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
