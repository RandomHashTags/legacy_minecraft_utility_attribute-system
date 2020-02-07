package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;

import java.util.HashMap;

public class SendMessage extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity e : recipientValues.keySet()) {
            if(e != null) {
                final String v = recipientValues.get(e);
                if(v != null) {
                    if(v.contains("\\n")) {
                        for(String s : v.split("\\n")) {
                            e.sendMessage(colorize(s));
                        }
                    } else {
                        e.sendMessage(colorize(v));
                    }
                }
            }
        }
    }
}
