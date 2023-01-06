package de.paintabletoast.system.command;

import de.paintabletoast.system.boot.Core;
import de.paintabletoast.system.manager.PluginHandler;
import de.paintabletoast.system.var.FileReplace;
import de.paintabletoast.system.var.Message;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public enum Command implements PluginHandler {
    ;
    private final Core core = JavaPlugin.getPlugin(Core.class);
    private String command;
    private CommandExecutor commandExecutor;
    private TabCompleter completer;
    Command( final CommandExecutor commandExecutor) {
        this.command = this.name().toLowerCase();
        this.commandExecutor = commandExecutor;
        registerCommand();
    }
    Command(final CommandExecutor commandExecutor, final TabCompleter tabcompleter) {
        this.command = this.name().toLowerCase();
        this.commandExecutor = commandExecutor;
        this.completer = tabcompleter;
        registerCommand();
    }
    private final void registerCommand() {
        try {
            core.getCommand(command).setExecutor(commandExecutor);
            if(this.getCompleter() != null) core.getCommand(command).setTabCompleter(completer);
            log(Message.COMMAND_SUCCESS.getMessage().replace(FileReplace.COMMAND.getPart(), command));
        } catch (final Exception error) {
            logError(error, Message.COMMAND_ERROR.getMessage().replace(FileReplace.COMMAND.getPart(), command));
        }
    }
    private final TabCompleter getCompleter() {
        return completer;
    }

}
