package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class RemovePotionEffect extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending, HashMap<String, String> valueReplacements) {
        final HashMap<String, Entity> entities = pending.getEntities();
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity e : recipientValues.keySet()) {
            removePotionEffect(entities, e, recipientValues.get(e), valueReplacements);
        }
    }
    private void removePotionEffect(HashMap<String, Entity> entities, Entity entity, String value, HashMap<String, String> valueReplacements) {
        if(entity instanceof LivingEntity) {
            final LivingEntity l = (LivingEntity) entity;
            final String[] values = replaceValue(entities, value, valueReplacements).split(":");
            final String effects = values[0];
            final boolean sendMessage = values.length >= 2 && Boolean.parseBoolean(values[1]);
            if(effects.contains(",")) {
                for(String string : effects.split(",")) {
                    removePotionEffect(l, string, valueReplacements, sendMessage);
                }
            } else {
                removePotionEffect(l, effects, valueReplacements, sendMessage);
            }
        }
    }
    private void removePotionEffect(LivingEntity entity, String input, HashMap<String, String> valueReplacements, boolean sendMessage) {
        final PotionEffectType type = getPotionEffectType(input);
        if(type != null) {
            entity.removePotionEffect(type);
            if(sendMessage) {
                sendMessage(entity, type, valueReplacements);
            }
        }
    }
    private void sendMessage(LivingEntity entity, PotionEffectType type, HashMap<String, String> valueReplacements) {
        final HashMap<String, String> replacements = new HashMap<>();
        if(valueReplacements != null) {
            replacements.putAll(valueReplacements);
        }
        replacements.put("{POTION_EFFECT}", type.getName());
        sendStringListMessage(entity, getRPConfig("custom enchants", "_settings.yml").getStringList("messages.remove potion effect"), replacements);
    }
}
