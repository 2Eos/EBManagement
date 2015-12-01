package eos.gir.ebmanagement.listeners;

import eos.gir.ebmanagement.core;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class MuteListener implements Listener {
    private final core plugin;

    public MuteListener(core plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

}
