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

    public static List<String> getNames() {
        String names = "name1\n" +
                "name2\n" +
                "name3\n" +
                "name4\n";

        return Arrays.asList(names.split("\n"));
    }

}
