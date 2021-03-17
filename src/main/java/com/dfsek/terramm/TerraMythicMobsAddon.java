package com.dfsek.terramm;

import com.dfsek.terra.api.TerraPlugin;
import com.dfsek.terra.api.addons.TerraAddon;
import com.dfsek.terra.api.addons.annotations.Addon;
import com.dfsek.terra.api.addons.annotations.Version;
import com.dfsek.terra.api.addons.annotations.Author;
import com.dfsek.terra.api.event.EventListener;
import com.dfsek.terra.api.event.events.config.ConfigPackPreLoadEvent;
import com.dfsek.terra.api.injection.annotations.Inject;
import com.dfsek.terra.registry.exception.DuplicateEntryException;

import java.util.logging.Logger;

@SuppressWarnings("unused")
@Addon("MythicMobs")
@Version("0.1.0")
@Author("dfsek")
public class TerraMythicMobsAddon extends TerraAddon implements EventListener {
    @Inject
    private TerraPlugin main;

    @Inject
    private Logger logger;

    public void onPackLoad(ConfigPackPreLoadEvent event) {
        try {
            event.getPack().getFunctionRegistry().add("mythicMob", new MythicMobsFunctionBuilder());
        } catch(DuplicateEntryException e) {
            e.printStackTrace();
            logger.severe("Failed to inject MythicMobs function!");
            return;
        }
        logger.info("Injected MythicMobs function!");
    }

    @Override
    public void initialize() {
        logger.info("Registering events...");
        main.getEventManager().registerListener(this, this);
        logger.info("Done.");
    }
}
