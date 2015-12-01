package eos.gir.ebmanagement.library.MySQL;


public class SQLTable {

    public static String TABLE_PROFILE = "profile";
    public static String TABLE_BANS = "bans";
    public static String TABLE_MUTES = "mutes";
    public static String TABLE_TEMPBANS = "tempban";
    public static String TABLE_IPS = "ips";
    public static String TABLE_DEBUFFS = "debuffs";

    public static String TABLE_QUERY_PROFILE = "CREATE TABLE IF NOT EXISTS `" + TABLE_PROFILE + "` (`UUID` varchar(40),`Name` varchar(32),`IP` varchar(14),`Total Bans` int(255),`Total Mutes` int(255),`Total Temp Bans` int(255), `Total Time Online` int(255), `Total Debuffs` int(255), `Last Ban Date` varchar(255)  )";
    public static String TABLE_QUERY_BANS = "CREATE TABLE IF NOT EXISTS `" + TABLE_BANS + "` (`UUID` varchar(40),`Name` varchar(32), `Banned by` varchar(32), `Banned on` varchar(32), `Reason` varchar(255), `Unbanned by` varchar(32), `Banned` int(1), `wasOffline` varchar(4) ) ";
    public static String TABLE_QUERY_MUTES = "CREATE TABLE IF NOT EXISTS `" + TABLE_MUTES + "` (`UUID` varchar(40),`Name` varchar(32),`Expires on` varchar(50), `Muted by` varchar(32), `Muted on` varchar(32), `Reason` varchar(255), `Unmuted by` varchar(32), `Muted` int(1) )";
    public static String TABLE_QUERY_TEMPBANS = "CREATE TABLE IF NOT EXISTS `" + TABLE_TEMPBANS + "` (`UUID` varchar(40),`Name` varchar(32),`Expires in` varchar(50), `Tempbanned by` varchar(32), `Tempbanned on` varchar(32), `Reason` varchar(255), `Unbanned by` varchar(32), `Tempbanned` int(1), `wasOffline` varchar(4) )";
    public static String TABLE_QUERY_IPS = "CREATE TABLE IF NOT EXISTS `" + TABLE_IPS + "` (`UUID` varchar(40),`Name` varchar(32),`IP` varchar(12))";
    public static String TABLE_QUERY_DEBUFFS = "CREATE TABLE IF NOT EXISTS `" + TABLE_DEBUFFS + "` (`UUID` varchar(40),`Name` varchar(32),`Expires in` varchar(50), `Debuffed by` varchar(32), `Debuffed on` varchar(32), `Reason` varchar(255), `Debuff Removed by` varchar(32), `Debuffed` int(1), `wasOffline` varchar(4) )";



    public static String TABLE_CREATE_QUERY = "INSERT INTO `" + TABLE_PROFILE + "` (`UUID`,`Name`, `IP`, `Total Bans`, `Total Mutes`, `Total Temp Bans`, `Total Time Online`, `Last Ban Date`, `Total Debuffs`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static String TABLE_LOAD_QUERY = "SELECT * FROM `" + TABLE_PROFILE + "`  WHERE `UUID`= ?";
    public static String TABLE_INSERT_QUERY_BANS = "INSERT INTO `" + TABLE_BANS + "` (`UUID`, `Name`, `Expires in`, `Banned by`, `Banned on`, `Reason`, `Banned`, `wasOffline`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


    public static int STARTER_TOTALBANS = 0;
    public static int STARTER_TOTALMUTES = 0;
    public static int STARTER_TOTALTEMPBANS = 0;
    public static int STARTER_TOTAlTIMEONLINE = 0;
    public static int STARTER_TOTAlDEBUFFS = 0;
    public static String STARTER_LASTBANDATE = "0";
}
