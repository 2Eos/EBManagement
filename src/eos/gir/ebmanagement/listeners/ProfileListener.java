package eos.gir.ebmanagement.listeners;

import eos.gir.ebmanagement.core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ProfileListener implements Listener {

    private final core plugin;

    public ProfileListener(core plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void createUserOnJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        plugin.con.generateProfile(player);
    }
}
