package ac.grim.grimac.api.events;

import ac.grim.grimac.api.AbstractCheck;
import ac.grim.grimac.api.GrimUser;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FlagEvent {
    private static final List<Object> Handlers = new ArrayList<>();
    private final GrimUser grimUser;
    @Getter
    private final AbstractCheck check;
    @Setter
    @Getter
    private boolean cancelled;

    public FlagEvent(GrimUser grimUser, AbstractCheck check) {
        this.grimUser = grimUser;
        this.check = check;
    }


    public GrimUser getPlayer() {
        return grimUser;
    }

    public double getViolations() {
        return check.getViolations();
    }

    @NotNull
    public static List<Object> getHandlers() {
        return Handlers;
    }

    public boolean isSetback() {
        return check.getViolations() > check.getSetbackVL();
    }

}
