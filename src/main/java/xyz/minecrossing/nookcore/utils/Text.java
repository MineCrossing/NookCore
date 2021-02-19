package xyz.minecrossing.nookcore.utils;

import org.bukkit.ChatColor;

public class Text {

    public static String colour(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
