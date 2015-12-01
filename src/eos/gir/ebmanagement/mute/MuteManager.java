package eos.gir.ebmanagement.mute;

import org.bukkit.OfflinePlayer;

public class MuteManager {
    private MuteManager() {}
    public static void createPermMute(OfflinePlayer player, String reason, boolean logged, boolean canUseCommand) {
        Mute mute = new Mute(player.getUniqueId(), player.getName());
        if(!canUseCommand){
            mute.blockCommands(true);
        }
        mute.setMute(true);
        mute.setPermanent(true);
        mute.setLogging(true);
        mute.setReason(reason);
    }

    public static void createTempMute(OfflinePlayer player, String name, String reason, int time, boolean canUseCommand) {
        Mute mute = new Mute(player.getUniqueId(), player.getName());
        if(!canUseCommand){
            mute.blockCommands(true);
        }
        mute.setMute(true);
        mute.setLogging(true);
        mute.setReason(reason);
        mute.setTime(time);
    }
}
