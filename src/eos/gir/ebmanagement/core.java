package eos.gir.ebmanagement;

import eos.gir.ebmanagement.storage.YamlStorage;
import org.bukkit.plugin.java.JavaPlugin;

public class core extends JavaPlugin {

    public YamlStorage yamlFile;

    public core(){}

    public void initialize(){
        yamlFile = new YamlStorage(this);
    }

    public void onEnable() {
        yamlFile.createYAML();
        try {
            initialize();
        } catch (Exception e) {

        }
    }
}
