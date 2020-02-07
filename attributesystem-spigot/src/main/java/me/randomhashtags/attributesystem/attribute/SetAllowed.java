package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SetAllowed extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending, String value) {
        final Event event = pending.getEvent();
        if(event instanceof PlayerCommandPreprocessEvent) {
            ((PlayerCommandPreprocessEvent) event).setCancelled(Boolean.parseBoolean(value));
        }
    }
}
