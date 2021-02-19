package xyz.minecrossing.nookcore.players;

import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerManager {

    public static void savePlayer(MinePlayer player) {
        String sql = "INSERT INTO players (uuid, name, time, level, kills, deaths, wins, losses, logins, quests) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE name = name, time = time, level = level, kills = kills, deaths = deaths, wins = wins, losses = losses, logins = logins, quests = quests";

        System.out.println(sql);

        try (Connection con = DatabaseConnector.getInstance().getConnection("minecrossing")) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, player.getPlayer().getUniqueId().toString());
            ps.setString(2, player.getPlayer().getName());
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

}
