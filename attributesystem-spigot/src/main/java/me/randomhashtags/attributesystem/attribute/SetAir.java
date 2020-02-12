package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class SetAir extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            if(entity instanceof Player) {
                final Player player = (Player) entity;
                final int air = player.getRemainingAir(), max = player.getMaximumAir(), total = (int) evaluate(recipientValues.get(entity).replace("air", Integer.toString(air)));
                player.setRemainingAir(Math.min(total, max));
            }
        }
    }
}
