package ac.grim.grimac;

import lombok.Getter;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class GrimAC implements ModInitializer{
    @Getter
    public static MinecraftServer SERVER = null;

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTING.register(this::onServerStarting);
        ServerLifecycleEvents.SERVER_STARTED.register(this::onServerStarted);
        ServerLifecycleEvents.SERVER_STOPPING.register(this::onServerStopping);
    }

    public void onServerStarting(MinecraftServer server) {
        SERVER = server;
    }

    public void onServerStarted(MinecraftServer server) {
        onLoad();
    }

    public void onServerStopping(MinecraftServer server) {
        onDisable();
    }

    public void onLoad() {
        GrimAPI.INSTANCE.load(getSERVER());
    }

    @Override
    public void onDisable() {
        GrimAPI.INSTANCE.stop(getSERVER());
    }

    @Override
    public void onEnable() {
        GrimAPI.INSTANCE.start(getSERVER());
    }


}
