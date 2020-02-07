package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public class SetCancelled extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending, String value) {
        final Event event = pending.getEvent();
        if(event instanceof Cancellable) {
            ((Cancellable) event).setCancelled(Boolean.parseBoolean(value));
        }
    }
}
