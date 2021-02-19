package xyz.minecrossing.nookcore.players;

import java.util.UUID;

public class MinePlayer {

    private final UUID uuid;
    private final String name;
    private final float playTime;
    private final int level, kills, deaths, wins, losses, logins, quests;

    public MinePlayer(UUID uuid, String name, float playTime, int level, int kills, int deaths, int wins, int losses, int logins, int quests) {
        this.uuid = uuid;
        this.name = name;
        this.playTime = playTime;
        this.level = level;
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.losses = losses;
        this.logins = logins;
        this.quests = quests;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
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
