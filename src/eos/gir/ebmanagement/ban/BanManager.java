package eos.gir.ebmanagement.ban;

import org.bukkit.OfflinePlayer;

public class BanManager {
    private BanManager() {}

    public static void createPermBan(OfflinePlayer player, String reason, boolean logged) {
        Ban ban = new Ban(player.getUniqueId(), player.getName());
        ban.setBan(true);
        ban.setPermanent(true);
        ban.setLogging(true);
        ban.setReason(reason);

    }

    public static void createTempBan(OfflinePlayer player, String name, String reason, int time) {
        Ban ban = new Ban(player.getUniqueId(), player.getName());
        ban.setBan(true);
        ban.setLogging(true);
        ban.setReason(reason);
        ban.setTime(time);
    }


    

}
