package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;

import java.util.HashMap;

public class SendMessage extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            if(entity != null) {
                final String value = recipientValues.get(entity);
                if(value != null) {
                    if(value.contains("\\n")) {
                        for(String s : value.split("\\n")) {
                            entity.sendMessage(colorize(s));
                        }
                    } else {
                        entity.sendMessage(colorize(value));
                    }
                }
            }
        }
    }
}
