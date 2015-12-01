package eos.gir.ebmanagement.storage.mysql;

import eos.gir.ebmanagement.core;
import eos.gir.ebmanagement.library.MySQL.MySQL;
import eos.gir.ebmanagement.library.MySQL.SQLTable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLStorage {

    private final core plugin;

     String dbhost;
     String dbport;
     String dbuser;
     String dbpass;
     String dbname;

    public MySQL sql;
    public java.sql.Connection c;
    public Statement statement;

    public MySQLStorage(core plugin) {
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
                            SQLTable.TABLE_IPS + ", " +
                            SQLTable.TABLE_DEBUFFS);
                } else {

                    statement.execute(SQLTable.TABLE_QUERY_PROFILE);
                    statement.execute(SQLTable.TABLE_QUERY_BANS);
                    statement.execute(SQLTable.TABLE_QUERY_MUTES);
                    statement.execute(SQLTable.TABLE_QUERY_TEMPBANS);
                    statement.execute(SQLTable.TABLE_QUERY_IPS);
                    statement.execute(SQLTable.TABLE_QUERY_DEBUFFS);

                    statement.close();
                    Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[EBManagement] Created the following tables: " +
                            SQLTable.TABLE_PROFILE + ", " +
                            SQLTable.TABLE_BANS + ", " +
                            SQLTable.TABLE_MUTES + ", " +
                            SQLTable.TABLE_TEMPBANS + ", " +
                            SQLTable.TABLE_IPS + ", " +
                            SQLTable.TABLE_DEBUFFS);
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


    public void generateProfile(Player player) {
        String UUID = player.getUniqueId().toString();
        String NAME = player.getName();
        String IPADDRESS = player.getAddress().getAddress().getHostAddress();
        try {
            ResultSet query = sql.querySQL("SELECT * FROM `" + SQLTable.TABLE_PROFILE + "`  WHERE `UUID`= '" + UUID + "';");
            PreparedStatement load = c.prepareStatement(SQLTable.TABLE_LOAD_QUERY);
            PreparedStatement create = c.prepareStatement(SQLTable.TABLE_CREATE_QUERY);
//    public static String TABLE_CREATE_QUERY = "INSERT INTO `" + TABLE_PROFILE + "` (`UUID`,`Name`, `IP`, `Total Bans`, `Total Mutes`, `Total Temp Bans`, `Total Time Online`, `Last Ban Date`, `Total Debuffs`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            if ( query.next() ) {
                load.setString(1, UUID);
                load.close();
                query.close();
            } else {

                create.setString(1, UUID);
                create.setString(2, NAME);
                create.setString(3, IPADDRESS);
                create.setInt(4, SQLTable.STARTER_TOTALBANS);
                create.setInt(5, SQLTable.STARTER_TOTALMUTES);
                create.setInt(6, SQLTable.STARTER_TOTALTEMPBANS);
                create.setInt(7, SQLTable.STARTER_TOTAlTIMEONLINE);
                create.setString(8, SQLTable.STARTER_LASTBANDATE);
                create.setInt(9, SQLTable.STARTER_TOTAlDEBUFFS);

                create.executeUpdate();
                create.close();
                query.close();
            }
        }   catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
