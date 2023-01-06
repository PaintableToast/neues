package de.paintabletoast.system.event;

import de.paintabletoast.system.var.FileReplace;
import de.paintabletoast.system.var.Message;
import de.paintabletoast.system.var.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public interface ListenerHandler extends Listener {
    default void sendNoPermissionMessage(final Player player) {
        sendSoundMessage(player, Message.NO_PERMISSION.getMessage(), Sounds.NO_PERMISSION.getSound());
    }
    default void sendSoundMessage(final Player player, final String message, final Sound sound) {
        sendSoundMessage(player, message, sound, false);
    }
    default void sendSoundMessage(final Player player, final String message, final Sound sound, final boolean open) {
        playSound(player, sound, open);
        player.sendMessage(message);
    }
    default void playSound(final Player player, final Sound sound) {
        player.playSound(player.getLocation(), sound, 1, 1);
    }
    default void playSound(final Player player, final Sound sound, boolean open) {
        if(open) player.getLocation().getWorld().playSound(player.getLocation(), sound, 1, 1);
        else playSound(player, sound);
    }
    default void sendWrongArgumentMessage(final Player player, final String argument) {
        sendSoundMessage(player, Message.WRONG_COMMAND_ARGUMENTATION.getMessage().replace(FileReplace.COMMAND_ARGUMENT.getPart(), argument), Sounds.WRONG_ARGS.getSound());
    }
    default void unallowedSender(final String command) {
        Bukkit.getConsoleSender().sendMessage(Message.NO_CONSOLE.getMessage().replace(FileReplace.COMMAND.getPart(), command));
    }
}