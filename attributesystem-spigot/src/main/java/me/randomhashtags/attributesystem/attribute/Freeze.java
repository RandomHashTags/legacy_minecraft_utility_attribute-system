package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import me.randomhashtags.randompackage.util.obj.TObject;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class Freeze extends AbstractEventAttribute {
    private static HashMap<Player, TObject> TASKS;
    @Override
    public void load() {
        super.load();
        TASKS = new HashMap<>();
    }
    @Override
    public void unload() {
        for(Player p : TASKS.keySet()) {
            final TObject t = TASKS.get(p);
            SCHEDULER.cancelTask((int) t.getFirst());
            p.setWalkSpeed((float) t.getSecond());
        }
        TASKS = null;
    }
    @Override
    public void execute(PendingEventAttribute pending) {
        final Event event = pending.getEvent();
        final PlayerQuitEvent q = event instanceof PlayerQuitEvent ? (PlayerQuitEvent) event : null;
        if(q != null) {
            final Player player = q.getPlayer();
            final TObject tobj = TASKS.getOrDefault(player, null);
            if(tobj != null) {
                SCHEDULER.cancelTask((int) tobj.getFirst());
                player.setWalkSpeed((float) tobj.getSecond());
                TASKS.remove(player);
            }
        }

        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            final Player player = entity instanceof Player ? (Player) entity : null;
            if(player != null) {
                final float previousWalkSpeed = player.getWalkSpeed();
                player.setWalkSpeed(0);
                final TObject t = new TObject(SCHEDULER.scheduleSyncDelayedTask(RANDOM_PACKAGE, () -> {
                    player.setWalkSpeed(previousWalkSpeed);
                    TASKS.remove(player);
                }, (int) evaluate(recipientValues.get(entity))), previousWalkSpeed, null);
                TASKS.put(player, t);
            }
        }
    }
}
