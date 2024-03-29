package xyz.minecrossing.nookcore.players;

import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerManager {

    /**
     * Save a player to the database
     *
     * @param player The player to save
     */
    public static void savePlayer(MinePlayer player) {
        String sql = "INSERT INTO players (uuid, name, time, level, kills, deaths, wins, losses, logins, quests) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE name = name, time = time, level = level, kills = kills, deaths = deaths, wins = wins, losses = losses, logins = logins, quests = quests";

        try (Connection con = DatabaseConnector.getInstance().getConnection("minecrossing")) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, player.getUUID().toString());
            ps.setString(2, player.getName());
            ps.setFloat(3, player.getPlayTime());
            ps.setInt(4, player.getLevel());
            ps.setInt(5, player.getKills());
            ps.setInt(6, player.getDeaths());
            ps.setInt(7, player.getWins());
            ps.setInt(8, player.getLosses());
            ps.setInt(9, player.getLogins());
            ps.setInt(10, player.getQuests());

            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a player with a name and a set of random statistics
     *
     * @param name The name of the player
     * @return The randomised player
     */
    public static MinePlayer randomPlayer(String name) {
        int time = ThreadLocalRandom.current().nextInt(500_000);
        int level = ThreadLocalRandom.current().nextInt(100);
        int kills = ThreadLocalRandom.current().nextInt(1000);
        int deaths = ThreadLocalRandom.current().nextInt(2000);
        int wins = ThreadLocalRandom.current().nextInt(500);
        int losses = ThreadLocalRandom.current().nextInt(500);
        int logins = ThreadLocalRandom.current().nextInt(1000);
        int quests = ThreadLocalRandom.current().nextInt(64);

        return new MinePlayer(
                UUID.randomUUID(),
                name,
                time,
                level,
                kills,
                deaths,
                wins,
                losses,
                logins,
                quests
        );
    }

    /**
     * Get a list of example random usernames
     *
     * @return A list of random usernames
     */
    public static List<String> getNames() {
        String names = "mossyresult\n" +
                "arthropodsturban\n" +
                "downdazzling\n" +
                "continentforefinger\n" +
                "spaceplumber\n" +
                "garlicfalling\n" +
                "grubbywed\n" +
                "piesvolunteer\n" +
                "patsyrare\n" +
                "rowerinvasion\n" +
                "avoidwoodcock\n" +
                "rainframework\n" +
                "waggishcalamitous\n" +
                "killincisive\n" +
                "handybroccoli\n" +
                "ramennap\n" +
                "kosheraustrian\n" +
                "megareference\n" +
                "deliverstretch\n" +
                "relayseven\n" +
                "fanlargely\n" +
                "lyricaltheater\n" +
                "disastrousnearly\n" +
                "lividforemast\n" +
                "subtlelopsided\n" +
                "wiltedfroze\n" +
                "peacechildish\n" +
                "poontangaccess\n" +
                "thumbsupconclusion\n" +
                "philipswrack\n" +
                "recoverroe\n" +
                "operatebrown\n" +
                "showerassure\n" +
                "framesnorkling\n" +
                "jovialkindly\n" +
                "dressingriptide\n" +
                "hockeybreak\n" +
                "dangeroustempt\n" +
                "shoemakerbogus\n" +
                "describewilling\n" +
                "unlockadvocate\n" +
                "aggressiveloser\n" +
                "fearfulcrumble\n" +
                "idolizedethereal\n" +
                "belatedperky\n" +
                "gymnasiumpattern\n" +
                "anorakcoloured\n" +
                "shoulderedfabric\n" +
                "fairleadoptimism\n" +
                "gameinvincible\n" +
                "mindlessgrowing\n" +
                "acrossrichness\n" +
                "rostrumhappen\n" +
                "growlcranky\n" +
                "twangelliptical\n" +
                "picklesguide\n" +
                "saplingroom\n" +
                "teammateherald\n" +
                "shellmuseum\n" +
                "nervousswitch\n" +
                "tosssake\n" +
                "weepingoriginally\n" +
                "impalacartier";

        return Arrays.asList(names.split("\n"));
    }

}
