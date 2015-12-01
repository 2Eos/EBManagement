package eos.gir.ebmanagement.listeners;

import eos.gir.ebmanagement.core;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class BanListener implements Listener {
    private final core plugin;

    public BanListener(core plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

}
