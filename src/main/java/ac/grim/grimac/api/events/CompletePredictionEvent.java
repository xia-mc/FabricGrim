package ac.grim.grimac.api.events;

import ac.grim.grimac.api.AbstractCheck;
import ac.grim.grimac.api.GrimUser;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CompletePredictionEvent extends FlagEvent {

    private static final List<Object> handlers = new ArrayList<>();
    @Getter
    private final double offset;
    private boolean cancelled;

    public CompletePredictionEvent(GrimUser grimUser, AbstractCheck check, double offset) {
        super(grimUser, check);
        this.offset = offset;
    }

    @NotNull
    public static List<Object> getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

}
