package eos.gir.ebmanagement.api;

import eos.gir.ebmanagement.core;
import org.bukkit.configuration.file.FileConfiguration;

public class YamlAPI {

    private core plugin;

    private YamlAPI(core plugin){ this.plugin = plugin; }

    public static FileConfiguration grabYAML() {
        core core = new core();
        return core.yamlFile.grabYAML();
    }

    public static void saveYAML() {
        core core = new core();
        core.yamlFile.saveYAML();
    }

}
