package eos.gir.ebmanagement.storage;

import eos.gir.ebmanagement.core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class YamlStorage {

    core plugin;

    public File file;
    public String path;
    FileConfiguration load;
    
    public YamlStorage(core plugin) {
        this.plugin = plugin;
        file = new File(plugin.getDataFolder(), "config.yml");
        path = plugin.getName() + ".Configuration";
        load = YamlConfiguration.loadConfiguration(file);
    }

    public void createYAML(){
        if ( !file.exists() ) {
            try {
                load.set(path + ".Database.Type", "MySQL");
                load.set(path + ".Database.Host", "");
                load.set(path + ".Database.Port", "");
                load.set(path + ".Database.Username", "");
                load.set(path + ".Database.Password", "");
                load.set(path + ".Database.Name", "");
                load.options().copyDefaults(true);
                load.save(file);
            }   catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public FileConfiguration grabYAML() {
        return load;
    }

    public void saveYAML() {
        if ( file.exists() ) {
            try {
                load.save(file);
                load.load(file);
            }   catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            createYAML();
        }
    }


}
