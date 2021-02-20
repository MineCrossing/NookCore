package xyz.minecrossing.nookcore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.entity.Player;
import xyz.minecrossing.nookcore.players.PlayerManager;
import xyz.minecrossing.nookcore.utils.Text;

@CommandAlias("adduser")
public class AddPlayerDataCommand extends BaseCommand {

    @Default
    public void addUser(Player player, String user) {
        PlayerManager.savePlayer(PlayerManager.randomPlayer(user));
        player.sendMessage(Text.colour("Successfully added player &a" + user + " &fwith random data!"));
    }

}
