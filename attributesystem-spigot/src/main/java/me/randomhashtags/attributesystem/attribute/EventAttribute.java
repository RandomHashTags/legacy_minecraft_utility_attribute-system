package me.randomhashtags.attributesystem.attribute;

import com.sun.istack.internal.NotNull;
import me.randomhashtags.attributesystem.EAStorage;
import me.randomhashtags.attributesystem.util.Identifiable;
import me.randomhashtags.attributesystem.util.Mathable;
import me.randomhashtags.attributesystem.PendingEventAttribute;
import me.randomhashtags.randompackage.util.RPPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;

import java.util.HashMap;

public interface EventAttribute extends Cancellable, Identifiable, Mathable, EAStorage {
    void load();
    void unload();
    void execute(@NotNull Entity entity1, @NotNull Entity entity2, @NotNull String value);

    void execute(@NotNull PendingEventAttribute pending);
    void execute(@NotNull PendingEventAttribute pending, @NotNull HashMap<String, String> valueReplacements);
    void execute(@NotNull PendingEventAttribute pending, @NotNull String value);
    void execute(@NotNull PendingEventAttribute pending, @NotNull String value, @NotNull HashMap<String, String> valueReplacements);

    void executeAt(@NotNull HashMap<Location, String> locations);
    void executeData(@NotNull HashMap<RPPlayer, String> recipientValues, @NotNull HashMap<String, String> valueReplacements);
    void executeData(@NotNull HashMap<String, Entity> entities, @NotNull HashMap<RPPlayer, String> recipientValues, @NotNull HashMap<String, String> valueReplacements);
}
