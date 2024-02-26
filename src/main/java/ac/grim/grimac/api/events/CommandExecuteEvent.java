package ac.grim.grimac.api.events;

import ac.grim.grimac.api.AbstractCheck;
import ac.grim.grimac.api.GrimUser;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandExecuteEvent extends FlagEvent {
    private static final List<Object> handlers = new ArrayList<>();

    private final AbstractCheck check;
    private final String command;

    public CommandExecuteEvent(GrimUser player, AbstractCheck check, String command) {
        super(player, check);
        this.check = check;
        this.command = command;
    }

    public AbstractCheck getCheck() {
        return check;
    }

    @NotNull
    public static List<Object> getHandlers() {
        return handlers;
    }

    public String getCommand() {
        return command;
    }

}
