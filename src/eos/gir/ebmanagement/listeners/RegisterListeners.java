package eos.gir.ebmanagement.listeners;

import eos.gir.ebmanagement.core;

public class RegisterListeners {

    core plugin;

    public RegisterListeners(core plugin) {
        this.plugin = plugin;
    }

    public void registerListeners() {
        new BanListener(plugin);
        new MuteListener(plugin);
        new ProfileListener(plugin);
    }
}
