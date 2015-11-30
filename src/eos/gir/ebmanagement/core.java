package eos.gir.ebmanagement;

import eos.gir.ebmanagement.storage.YamlStorage;
import org.bukkit.plugin.java.JavaPlugin;

public class core extends JavaPlugin {

    public YamlStorage yamlFile;

    public void initialize(){
        yamlFile = new YamlStorage(this);
    }


    public core(){}

    public void onEnable() {
        try {
            initialize();
        } catch (Exception e) {

        }
        yamlFile.createYAML();

    }
}
