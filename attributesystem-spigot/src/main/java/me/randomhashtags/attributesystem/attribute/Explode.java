package me.randomhashtags.attributesystem.attribute;

import org.bukkit.Location;

import java.util.HashMap;

public class Explode extends AbstractEventAttribute {
    @Override
    public void executeAt(HashMap<Location, String> locations) {
        for(Location l : locations.keySet()) {
            final String v = locations.get(l);
            if(v != null) {
                final String[] values = v.split(":");
                final int size = values.length;
                l.getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), (float) evaluate(values[1]), size >= 3 && Boolean.parseBoolean(values[2]), size >= 4 && Boolean.parseBoolean(values[3]));
            }
        }
    }
}
