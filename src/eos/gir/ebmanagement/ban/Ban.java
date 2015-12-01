package eos.gir.ebmanagement.ban;

import java.util.UUID;

public class Ban {

    /*
    Constructor Class, new Ban(UUID, Name)
    Methods:
    setPermanent
    setTime
     */

    private UUID uuid;
    private String name;
    private String reason;
    private boolean banplayer;
    private boolean permban;
    private boolean logged;
    private int time;

    public Ban(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public void setBan(boolean banplayer) {
        this.banplayer = banplayer;
    }

    public void setPermanent(boolean permban) {
        this.permban = permban;
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

    public Boolean getBan() { return permban; }
    public String getReason() { return reason; }

}
