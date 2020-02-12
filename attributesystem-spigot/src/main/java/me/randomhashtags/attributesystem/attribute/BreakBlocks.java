package me.randomhashtags.attributesystem.attribute;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.util.HashMap;

public class BreakBlocks extends AbstractEventAttribute {
    @Override
    public void executeAt(HashMap<Location, String> locations) {
        for(Location l : locations.keySet()) {
            final Block block = l.getBlock();
            final String[] values = locations.get(l).split(":");
            final int valuesLength = values.length, ticks = valuesLength >= 2 ? Integer.parseInt(values[1]) : -1;
            final boolean naturally = valuesLength >= 1 && Boolean.parseBoolean(values[0]);
            if(ticks != -1) {
                final Material m = block.getType();
                final byte data = block.getData();
                final BlockState blockstate = block.getState();
                SCHEDULER.scheduleSyncDelayedTask(ATTRIBUTE_SYSTEM, () -> {
                    block.setType(m);
                    if(LEGACY) {
                        blockstate.setRawData(data);
                    }
                    blockstate.update();
                }, ticks);
            }
            if(naturally) {
                block.breakNaturally();
            } else {
                block.setType(Material.AIR);
            }
        }
    }
}
