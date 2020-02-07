package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import me.randomhashtags.randompackage.event.DepleteRarityGemEvent;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

import java.util.HashMap;

public class SetDepleteAmount extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending, String value, HashMap<String, String> valueReplacements) {
        final Event event = pending.getEvent();
        final HashMap<String, Entity> entities = pending.getEntities();
        if(event instanceof DepleteRarityGemEvent) {
            final DepleteRarityGemEvent e = (DepleteRarityGemEvent) event;
            e.setDepleteAmount((int) evaluate(replaceValue(entities, value, valueReplacements)));
        }
    }
}
