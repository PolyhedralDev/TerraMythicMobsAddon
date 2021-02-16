package com.dfsek.terramm;

import com.dfsek.terra.api.core.TerraPlugin;
import com.dfsek.terra.api.core.event.EventListener;
import com.dfsek.terra.api.core.event.events.config.ConfigPackPreLoadEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TerraMythicMobsAddon extends JavaPlugin implements EventListener {
    @Override
    public void onLoad() {
        TerraPlugin main = (TerraPlugin) Bukkit.getPluginManager().getPlugin("Terra");
        main.getEventManager().registerListener(this);
    }

    public void onPackLoad(ConfigPackPreLoadEvent event) {
        event.getPack().getFunctionRegistry().add("mythicMob", new MythicMobsFunctionBuilder());
        getLogger().info("Injected MythicMobs function!");
    }
}
