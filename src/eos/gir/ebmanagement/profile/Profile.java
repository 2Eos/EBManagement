package eos.gir.ebmanagement.profile;

public class Profile {

    private String uuid;
    private String name;
    private String ip;
    private int totalbans;
    private int totalmutes;
    private int totaltempbans;
    private String lastbandate;

    public Profile(String uuid, String name, String ip, int totalbans, int totalmutes, int totaltempbans, String lastbandate) {
        this.uuid = uuid;
        this.name = name;
        this.ip = ip;
        this.totalbans = totalbans;
        this.totalmutes = totalmutes;
        this.totaltempbans = totaltempbans;
        this.lastbandate = lastbandate;
    }

    public String getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getTotalBans() {
        return totalbans;
    }

    public int getTotalmutes() {
        return totalmutes;
    }

    public int getTotalTempBans() {
        return totaltempbans;
    }

    private String getLastbandate() {
        return lastbandate;
    }



}
