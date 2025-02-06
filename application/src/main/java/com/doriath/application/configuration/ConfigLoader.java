package com.doriath.application.configuration;

import com.doriath.application.App;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConfigLoader extends HashMap<ConfigOption, Boolean> {
    public static final Path configFile = Paths.get(App.configPath + "\\application.config");

    public ConfigLoader() throws IOException {
        super();
        if (!Files.exists(configFile)){
            initConfigFile();
        }
        load();
    }

    private void initConfigFile() throws IOException {
        List<String> lines = new ArrayList<>();
        for (var option : ConfigOption.values()){
            lines.add(option.getName() + "=" + option.getDefaultValue());
        }
        Files.write(configFile, lines);
    }

    public void load() throws IOException {
        var i = Files.readAllLines(configFile).iterator();
        for (var option : ConfigOption.values()){
            String value = i.next().split("=")[1];
            put(option, Boolean.parseBoolean(value));
        }
    }

    public void save() throws IOException {
        List<String> lines = new ArrayList<>();
        for (var option : ConfigOption.values()){
            lines.add(option.getName() + "=" + get(option));
        }
        Files.write(configFile, lines);
    }

}
