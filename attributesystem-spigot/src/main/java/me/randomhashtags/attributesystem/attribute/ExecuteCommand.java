package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;

import java.util.HashMap;

public class ExecuteCommand extends AbstractEventAttribute {
    @Override
    public void execute(String value) {
        SERVER.dispatchCommand(CONSOLE, value);
    }
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity e : recipientValues.keySet()) {
            SERVER.dispatchCommand(e, recipientValues.get(e).replace("%entity%", e.getName()));
        }
    }
}
