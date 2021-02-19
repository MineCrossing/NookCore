package xyz.minecrossing.nookcore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.minecrossing.nookcore.utils.Text;

@CommandAlias("fly")
public class FlyCommand extends BaseCommand {

    @Default
    public void fly(Player player) {
        player.setAllowFlight(player.getAllowFlight());
        player.sendMessage(Text.colour("&aFlight toggled!"));
    }
}
