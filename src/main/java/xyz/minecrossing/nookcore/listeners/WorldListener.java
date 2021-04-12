package xyz.minecrossing.nookcore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.minecrossing.coreutilities.CoreUtilities;
import xyz.minecrossing.nookcore.Main;
import xyz.minecrossing.nookcore.players.MinePlayer;
import xyz.minecrossing.nookcore.players.PlayerManager;

/**
 * When a player joins alter their health, food, and gamemode to suite the game.
 * Manages a lot of world events to control player actions.
 */
public class WorldListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setFoodLevel(20);

        int time = player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
        int level = player.getLevel();
        int kills = player.getStatistic(Statistic.MOB_KILLS) + player.getStatistic(Statistic.PLAYER_KILLS);
        int deaths = player.getStatistic(Statistic.DEATHS);
        int logins = player.getStatistic(Statistic.LEAVE_GAME) + 1;

        // Save the player's into the database.
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            PlayerManager.savePlayer(new MinePlayer(player.getUniqueId(), player.getName(), time, level, kills, deaths, 0, 0, logins, 0));
        });
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getPlayer().isOp()) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getPlayer().isOp()) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPhysics(BlockPhysicsEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityDrop(EntityDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        event.setCancelled(true);
    }

}
