package me.randomhashtags.attributesystem;

import org.bukkit.plugin.java.JavaPlugin;

public final class AttributeSystemSpigot extends JavaPlugin {

    public static AttributeSystemSpigot getPlugin;

    @Override
    public void onEnable() {
        getPlugin = this;
        enable();
    }

    @Override
    public void onDisable() {
        disable();
    }

    public void enable() {
        EventAttributes.loadEventAttributes();
    }
    public void disable() {
        EventAttributes.unloadEventAttributes();
    }

    public void reload() {
        disable();
        enable();
    }
}
