package me.randomhashtags.attributesystem.attribute;

import com.sun.istack.internal.NotNull;
import me.randomhashtags.attributesystem.AttributeType;
import me.randomhashtags.attributesystem.EventReplacer;
import me.randomhashtags.attributesystem.PendingEventAttribute;
import me.randomhashtags.attributesystem.universal.UVersionable;
import me.randomhashtags.randompackage.supported.RegionalAPI;
import me.randomhashtags.randompackage.util.RPPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.HashMap;

public abstract class AbstractEventAttribute extends RegionalAPI implements EventAttribute, EventReplacer, UVersionable {
    private boolean cancelled;
    public String getIdentifier() {
        final String[] n = getClass().getName().split("\\.");
        return n[n.length-1].toUpperCase();
    }
    public void load() {
        register(AttributeType.ATTRIBUTE, this);
    }
    public void unload() {}

    public boolean isCancelled() { return cancelled; }
    public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }

    public void execute(@NotNull PendingEventAttribute pending) {}
    public void execute(@NotNull PendingEventAttribute pending, @NotNull HashMap<String, String> valueReplacements) {}
    public void execute(@NotNull PendingEventAttribute pending, @NotNull String value) {}
    public void execute(@NotNull PendingEventAttribute pending, @NotNull String value, @NotNull HashMap<String, String> valueReplacements) {}

    public void execute(String value) {}
    public void execute(Entity entity1, Entity entity2, String value) {}
    public void executeAt(HashMap<Location, String> locations) {}
    public void executeData(HashMap<RPPlayer, String> recipientValues, HashMap<String, String> valueReplacements) {}
    public void executeData(HashMap<String, Entity> entities, HashMap<RPPlayer, String> recipientValues, HashMap<String, String> valueReplacements) {}
}
