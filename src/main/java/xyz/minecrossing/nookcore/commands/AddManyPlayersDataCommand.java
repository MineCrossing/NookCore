package xyz.minecrossing.nookcore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.entity.Player;
import xyz.minecrossing.nookcore.players.PlayerManager;
import xyz.minecrossing.nookcore.utils.Text;

import java.util.List;

@CommandAlias("addallplayers")
public class AddManyPlayersDataCommand extends BaseCommand {

    @Default
    public void addAll(Player player) {
        List<String> names = PlayerManager.getNames();
        for (String name : names) {
            player.sendMessage(Text.colour("&aAdding: &e" + name));
            PlayerManager.savePlayer(PlayerManager.randomPlayer(name));
        }

        player.sendMessage(Text.colour("Successfully added &a" + names.size() + " &fnames!"));
    }

}
