package eos.gir.ebmanagement.library.MySQL;

public class SQLTable {

    public static String TABLE_PROFILE = "profile";
    public static String TABLE_BANS = "bans";
    public static String TABLE_MUTES = "mutes";
    public static String TABLE_TEMPBANS = "tempban";
    public static String TABLE_IPS = "ips";

    public static String TABLE_QUERY_PROFILE = "CREATE TABLE IF NOT EXISTS `" + TABLE_PROFILE + "` (`UUID` varchar(40),`Name` varchar(32),`IP` varchar(12),`Total Bans` int(32),`Total Mutes` int(32),`Total Temp Bans` int(32), `Total Time Online` int(32), `Last Ban Date` varchar(255) )";
    public static String TABLE_QUERY_BANS = "CREATE TABLE IF NOT EXISTS `" + TABLE_BANS + "` (`UUID` varchar(40),`Name` varchar(32),`Expires on` varchar(50), `Banned by` varchar(32), `Banned on` varchar(32), `Reason` varchar(255), `Unbanned by` varchar(32), `Banned` int(1) ) ";
    public static String TABLE_QUERY_MUTES = "CREATE TABLE IF NOT EXISTS `" + TABLE_MUTES + "` (`UUID` varchar(40),`Name` varchar(32),`Expires on` varchar(50), `Muted by` varchar(32), `Muted on` varchar(32), `Reason` varchar(255), `Unmuted by` varchar(32), `Muted` int(1) )";
    public static String TABLE_QUERY_TEMPBANS = "CREATE TABLE IF NOT EXISTS `" + TABLE_TEMPBANS + "` (`UUID` varchar(40),`Name` varchar(32),`Expires in` varchar(50), `Tempbanned by` varchar(32), `Tempbanned on` varchar(32), `Reason` varchar(255), `Unbanned by` varchar(32), `Tempbanned` int(1) )";
    public static String TABLE_QUERY_IPS = "CREATE TABLE IF NOT EXISTS `" + TABLE_IPS + "` (`UUID` varchar(40),`Name` varchar(32),`IP` varchar(12))";

}
