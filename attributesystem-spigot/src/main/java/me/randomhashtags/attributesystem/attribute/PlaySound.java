package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlaySound extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            playsound(entity, recipientValues.get(entity), true);
        }
    }
    @Override
    public void executeAt(HashMap<Location, String> locations) {
        for(Location l : locations.keySet()) {
            playsound(l, locations.get(l), false);
        }
    }
    private void playsound(Object obj, String value, boolean isEntity) {
        final Player p = isEntity ? (Player) obj : null;
        final Location l = isEntity ? p.getLocation() : (Location) obj;

        final String[] a = value.split(":");
        final int count = a.length, plays = count >= 4 ? (int) evaluate(a[3]) : 1;
        final boolean world = !isEntity || count >= 5 && Boolean.parseBoolean(a[4]);
        final World w = l.getWorld();
        final Sound s = Sound.valueOf(a[0].toUpperCase());
        final float f1 = (float) evaluate(a[1]), f2 = (float) evaluate(a[2]);
        for(int i = 1; i <= plays; i++) {
            if(world) {
                w.playSound(l, s, f1, f2);
            } else {
                p.playSound(l, s, f1, f2);
            }
        }
    }
}
