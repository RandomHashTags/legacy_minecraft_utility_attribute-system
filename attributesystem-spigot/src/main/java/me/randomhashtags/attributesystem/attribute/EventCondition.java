package me.randomhashtags.attributesystem.attribute;

import com.sun.istack.internal.NotNull;
import me.randomhashtags.attributesystem.util.Identifiable;
import me.randomhashtags.attributesystem.util.Mathable;
import me.randomhashtags.attributesystem.EAStorage;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

import java.util.HashMap;

public interface EventCondition extends Identifiable, Mathable, EAStorage {
    void load();
    void unload();
    boolean check(@NotNull String value);
    boolean check(@NotNull Event event);
    boolean check(@NotNull Event event, @NotNull Entity entity);
    boolean check(@NotNull Event event, @NotNull String value);
    boolean check(@NotNull Entity entity, @NotNull String value);
    boolean check(@NotNull String entity, @NotNull HashMap<String, Entity> entities, @NotNull String value);
}
