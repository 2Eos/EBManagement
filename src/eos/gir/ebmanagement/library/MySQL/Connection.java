package eos.gir.ebmanagement.library.MySQL;

import eos.gir.ebmanagement.core;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {

    private final core plugin;


    private String dbhost;
    private String dbport;
    private String dbuser;
    private String dbpass;
    private String dbname;

    public MySQL sql;
    public java.sql.Connection c;
    public Statement statement;

    public Connection(core plugin) {
        this.plugin = plugin;
        dbhost = plugin.yamlFile.grabYAML().getString(plugin.yamlFile.path + ".Database.Host");
        dbport = plugin.yamlFile.grabYAML().getString(plugin.yamlFile.path + ".Database.Port");
        dbuser = plugin.yamlFile.grabYAML().getString(plugin.yamlFile.path + ".Database.Username");
        dbpass = plugin.yamlFile.grabYAML().getString(plugin.yamlFile.path + ".Database.Password");
        dbname = plugin.yamlFile.grabYAML().getString(plugin.yamlFile.path + ".Database.Name");

        try {
            sql = new MySQL(plugin, dbhost, dbport, dbname, dbuser, dbpass);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void generateMySQLTables() {
        try {
            DatabaseMetaData dbm = c.getMetaData();
            ResultSet tablesex = dbm.getTables(null, null, "%", null);
            statement = sql.getConnection().createStatement();

            sql.openConnection();

        }   catch (Exception e) {

        }
    }


}
