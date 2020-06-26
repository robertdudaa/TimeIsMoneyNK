package de.robasse.timeismoney;

import cn.nukkit.plugin.PluginBase;
import de.robasse.timeismoney.configuration.ConfigHandler;
import de.robasse.timeismoney.configuration.ConfigStore;

public class TimeIsMoney extends PluginBase {

    private ConfigStore configStore;

    @Override
    public void onEnable() {
        ConfigHandler configHandler = new ConfigHandler(this);
        configHandler.retrieveConfig().ifPresent(value -> this.configStore = value);
        if (!configHandler.retrieveConfig().isPresent()) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }


    }

    @Override
    public void onDisable() {
    }

    public ConfigStore getConfigStore() {
        return configStore;
    }
}
