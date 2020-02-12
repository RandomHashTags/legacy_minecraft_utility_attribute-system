package me.randomhashtags.attributesystem.attribute.condition;

import me.randomhashtags.attributesystem.attribute.AbstractEventCondition;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;

public class HitBlock extends AbstractEventCondition {
    @Override
    public boolean check(Event event, String value) {
        final PlayerInteractEvent e = event instanceof PlayerInteractEvent ? (PlayerInteractEvent) event : null;
        if(e != null) {
            final Block block = e.getClickedBlock();
            return block != null && block.getType().name().endsWith(value.toUpperCase());
        }
        return false;
    }
}
