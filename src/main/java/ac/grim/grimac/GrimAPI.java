package ac.grim.grimac;

import ac.grim.grimac.api.GrimAbstractAPI;
import ac.grim.grimac.manager.*;
import ac.grim.grimac.utils.anticheat.PlayerDataManager;
import lombok.Getter;
import net.minecraft.server.MinecraftServer;

@Getter
public enum GrimAPI {
    INSTANCE;

    private final AlertManager alertManager = new AlertManager();
    private final SpectateManager spectateManager = new SpectateManager();
    private final DiscordManager discordManager = new DiscordManager();
    private final PlayerDataManager playerDataManager = new PlayerDataManager();
    private final TickManager tickManager = new TickManager();
    private final GrimExternalAPI externalAPI = new GrimExternalAPI(this);
    private InitManager initManager;
    private ConfigManager configManager;
    private static MinecraftServer SERVER;

    public void load(final MinecraftServer plugin) {
        SERVER = plugin;
        this.configManager = new ConfigManager();
        initManager = new InitManager();
        initManager.load();
    }

    public void start(final MinecraftServer plugin) {
        SERVER = plugin;
        initManager.start();
        Bukkit.getServicesManager().register(GrimAbstractAPI.class, externalAPI, plugin, ServicePriority.Normal);
    }

    public void stop(final MinecraftServer plugin) {
        SERVER = plugin;
        initManager.stop();
    }
}
