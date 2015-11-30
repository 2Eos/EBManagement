package eos.gir.ebmanagement.library.MySQL;

import eos.gir.ebmanagement.core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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

        sql = new MySQL(plugin, dbhost, dbport, dbname, dbuser, dbpass);
        try {
            c = sql.openConnection();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void generateMySQLTables() {
        if (plugin.yamlFile.getStringYAML(".Database.Type").equalsIgnoreCase("MySQL")) {
            try {
                DatabaseMetaData dbm = c.getMetaData();
                ResultSet nextable = dbm.getTables(null, null, "%", null);
                statement = this.sql.getConnection().createStatement();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[EBManagement] Initializing MySQL Database...");

                sql.openConnection();

                if (nextable.next()) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[EBManagement] Loaded the following tables: " +
                            SQLTable.TABLE_PROFILE + ", " +
                            SQLTable.TABLE_BANS + ", " +
                            SQLTable.TABLE_MUTES + ", " +
                            SQLTable.TABLE_TEMPBANS + ", " +
                            SQLTable.TABLE_IPS);
                } else {

                    statement.execute(SQLTable.TABLE_QUERY_PROFILE);
                    statement.execute(SQLTable.TABLE_QUERY_BANS);
                    statement.execute(SQLTable.TABLE_QUERY_MUTES);
                    statement.execute(SQLTable.TABLE_QUERY_TEMPBANS);
                    statement.execute(SQLTable.TABLE_QUERY_IPS);

                    statement.close();
                    sql.closeConnection();

                    Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[EBManagement] Created the following tables: " +
                            SQLTable.TABLE_PROFILE + ", " +
                            SQLTable.TABLE_BANS + ", " +
                            SQLTable.TABLE_MUTES + ", " +
                            SQLTable.TABLE_TEMPBANS + ", " +
                            SQLTable.TABLE_IPS);
                }

            } catch (Exception e) {
            }
        }
    }

    public void openConnection() {
        try {
            sql.openConnection();
        }   catch (Exception e) {

        }
    }

    public void closeConnection() {
        try {
            sql.closeConnection();
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }


}
