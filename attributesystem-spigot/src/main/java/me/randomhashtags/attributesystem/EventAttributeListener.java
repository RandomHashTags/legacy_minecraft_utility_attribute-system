package me.randomhashtags.attributesystem;

import com.sun.istack.internal.NotNull;
import me.randomhashtags.attributesystem.util.Identifiable;
import org.bukkit.event.Event;

public interface EventAttributeListener extends Identifiable {
    void called(@NotNull Event event);
}
