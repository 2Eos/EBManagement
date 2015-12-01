package eos.gir.ebmanagement;

import eos.gir.ebmanagement.library.command.CommandFramework;
import eos.gir.ebmanagement.listeners.RegisterListeners;
import eos.gir.ebmanagement.storage.mysql.MySQLStorage;
import eos.gir.ebmanagement.storage.yaml.YamlStorage;
import org.bukkit.plugin.java.JavaPlugin;

public class core extends JavaPlugin {

    public YamlStorage yamlFile;
    public CommandFramework framework;
    public MySQLStorage con;
    public RegisterListeners registerListeners;

    public void initialize(){
        yamlFile = new YamlStorage(this);
        con = new MySQLStorage(this);
        registerListeners = new RegisterListeners(this);
    }

    public void onEnable() {

        try {
            initialize();
        } catch (Exception e) {

        }

        con.openConnection();
        yamlFile.createYAML();
        con.generateMySQLTables();
        registerListeners.registerListeners();
        framework = new CommandFramework(this);
        framework.registerCommands(this);


    }

    public void onDisable() {
        con.closeConnection();
    }
}
