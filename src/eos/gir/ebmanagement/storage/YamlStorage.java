package eos.gir.ebmanagement.storage;

import eos.gir.ebmanagement.core;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class YamlStorage {

    core plugin;

    public File file;
    public String path;
    FileConfiguration load;

    public YamlStorage(core plugin) {
        this.plugin = plugin;
        file = new File(plugin.getDataFolder(), "config.yml");
        path = plugin.getName() + ".Configuration.Settings";
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

    public void setYAML(String pathto, int value) {
        load.set(path + "." + pathto, value);
    }
    public void setYAML(String pathto, String value) {
        load.set(path + "." + pathto, value);
    }

    public Integer getIntYAML(String pathto){
        return load.getInt(path + pathto);
    }

    public String getStringYAML(String pathto){
        return load.getString(path + pathto);
    }

    public ConfigurationSection getSectionYAML(String pathto){
        return load.getConfigurationSection(path + pathto);
    }

    public List<String> getStringListYAML(String pathto){
        return load.getStringList(path + pathto);
    }

    public List getListYAML(String pathto){
        return load.getList(path + pathto);
    }

}
