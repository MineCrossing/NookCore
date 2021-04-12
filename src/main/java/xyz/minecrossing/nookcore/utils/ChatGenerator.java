package xyz.minecrossing.nookcore.utils;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.minecrossing.nookcore.Main;
import xyz.minecrossing.nookcore.players.PlayerManager;
import xyz.minecrossing.redisapi.RedisAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Generate random chat messages with random names to be sent to Redis and in-game
 */
public class ChatGenerator extends BukkitRunnable {

    private static final long DELAY = 100;

    @Override
    public void run() {
        String name = PlayerManager.getNames().get(ThreadLocalRandom.current().nextInt(PlayerManager.getNames().size()));
        String message = getMessages().get(ThreadLocalRandom.current().nextInt(getMessages().size()));

        String result = name + ": " + message;
        Main.getInstance().getRedisConnection().publish("gameChat", result);
        Bukkit.broadcastMessage(result);
    }

    /**
     * Get the delay between chat messages
     *
     * @return The delay between chat messages
     */
    public long getTime() {
        return DELAY;
    }

    /**
     * Get a list of example scraped chat messages to use in the chat box
     *
     * @return A list of example chat messages
     */
    public static List<String> getMessages() {
        return Arrays.asList(
                "Can I have OP?",
                "I'm from planet minecraft!",
                "Has anyone got any logs?",
                "I SEE A DREAMER",
                "hi ani orit",
                "pen",
                "now buy me vip",
                "PvP on the plots",
                "someone gift me mvp+ plz",
                "PLEASE RANK UP",
                "1/2 say 123",
                "1v1 on hypixel?",
                "please anyone can gift me vip?",
                "Does anyone have diamonds?",
                "Who wants to trade with the villagers?",
                "Anyone got an overlay? Im lazy",
                "YEET",
                "If you gift me MVP+ Ill play bedwars with you",
                "any low star discord groups?",
                "Any doubles doing?",
                "I wanna play doubles",
                "is therea nyone who would 1v1 me if I win I get rank upgrade :)",
                "any 4v4s?",
                "im just gonna sit here and read lobby chat whilst eatong my food",
                "lol I got 4.8",
                "RaNk pLs",
                "Can some1 pleassee gif e a rankup PLEASE",
                "anyone have a public mine?",
                "Our guilds open if you are level 80+ and want to join DM me",
                "Theres parkour at our place if you want to",
                "inv me",
                "can someone help me build this house?",
                "anyone have a public xp grinder?",
                "AAAAAAAAAAAAAAAAA",
                "how you doing?",
                "good morning!",
                "gie me a shout when you are loaded in",
                "someone come play classic with me",
                "were hunting the dragon party me if you want in",
                "anyone iyn",
                "456 defence atm",
                "anyone found herobrine yet? xD",
                "how do I report someone?",
                "i founda scammer how report/",
                "Skyblock anyone?",
                "i have superior on skyblock",
                "shuld have joined later",
                "AHHHHHHHHHHHHHHHH",
                "check out my yt plz!",
                "im live on twitch rn",
                "anyone seen techno?"
        );
    }

}
