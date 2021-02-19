package xyz.minecrossing.nookcore.players;

import org.bukkit.entity.Player;

public class MinePlayer {

    private final Player player;
    private final float playTime;
    private final int level, kills, deaths, wins, losses, logins, quests;

    public MinePlayer(Player player, float playTime, int level, int kills, int deaths, int wins, int losses, int logins, int quests) {
        this.player = player;
        this.playTime = playTime;
        this.level = level;
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.losses = losses;
        this.logins = logins;
        this.quests = quests;
    }

    public Player getPlayer() {
        return player;
    }

    public float getPlayTime() {
        return playTime;
    }

    public int getLevel() {
        return level;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getLogins() {
        return logins;
    }

    public int getQuests() {
        return quests;
    }
}
