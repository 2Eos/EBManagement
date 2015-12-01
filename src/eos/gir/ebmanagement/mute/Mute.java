package eos.gir.ebmanagement.mute;

import java.util.UUID;


public class Mute {
    private UUID uuid;
    private String name;
    private String reason;
    private boolean mutePlayer;
    private boolean permMute;
    private boolean logged;
    private boolean blockCommands;
    private int time;

    public Mute(UUID uuid, String name){
        this.uuid = uuid;
        this.name = name;
    }
    public void setMute(boolean mutePlayer){
        this.mutePlayer = mutePlayer;
    }
    public void blockCommands(boolean blockCommands) {
        this.blockCommands = blockCommands;
    }
    public void setPermanent(boolean permMute) {
        this.permMute = permMute;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public void setLogging(boolean logged) {
        this.logged = logged;
    }

}
