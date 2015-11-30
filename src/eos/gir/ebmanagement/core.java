package eos.gir.ebmanagement;

import eos.gir.ebmanagement.library.command.CommandFramework;
import eos.gir.ebmanagement.storage.YamlStorage;
import org.bukkit.plugin.java.JavaPlugin;

public class core extends JavaPlugin {

    public YamlStorage yamlFile;
    public CommandFramework framework;


    public core(){}

    public void initialize(){
        yamlFile = new YamlStorage(this);
    }

    public void onEnable() {

        try {
            initialize();
        } catch (Exception e) {

        }

        yamlFile.createYAML();
        framework = new CommandFramework(this);
        framework.registerCommands(this);

    }
}
