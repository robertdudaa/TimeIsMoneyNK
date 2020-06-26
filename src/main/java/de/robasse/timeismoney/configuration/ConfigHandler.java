package de.robasse.timeismoney.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import de.robasse.timeismoney.TimeIsMoney;

import java.io.*;
import java.util.Optional;

public class ConfigHandler {

    private final TimeIsMoney plugin;
    private final Gson gson;

    public ConfigHandler(TimeIsMoney plugin) {
        this.plugin = plugin;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.loadConfig();
    }

    private void loadConfig() {
        ConfigStore configStore = new ConfigStore();
        File file = new File(plugin.getServer().getFilePath() + "plugins/timeismoney/config.json");
        if (file.getParentFile().exists()) {
            return;
        }
        file.getParentFile().mkdirs();
        try {
            FileWriter fileWriter = new FileWriter(file);
            gson.toJson(configStore, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<ConfigStore> retrieveConfig() {
        try {
            return Optional.of(gson.fromJson(new JsonReader(new FileReader(plugin.getServer().getFilePath() + "plugins/timeismoney/config.json")), ConfigStore.class));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
