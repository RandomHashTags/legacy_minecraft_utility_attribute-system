package me.randomhashtags.attributesystem;

import me.randomhashtags.attributesystem.attribute.EventAttribute;
import me.randomhashtags.attributesystem.attribute.EventCondition;
import me.randomhashtags.attributesystem.util.Identifiable;

import java.util.HashSet;
import java.util.Set;

public interface EAStorage {
    Set<EventAttribute> EVENT_ATTRIBUTES = new HashSet<>();
    Set<EventCondition> EVENT_CONDITIONS = new HashSet<>();
    Set<EventAttributeListener> EVENT_ATTRIBUTE_LISTENERS = new HashSet<>();
    default void register(AttributeType type, Identifiable eventIdentifier) {
        switch (type) {
            case ATTRIBUTE:
                if(!EVENT_ATTRIBUTES.contains(eventIdentifier)) {
                    EVENT_ATTRIBUTES.add((EventAttribute) eventIdentifier);
                }
                break;
            case CONDITION:
                if(!EVENT_CONDITIONS.contains(eventIdentifier)) {
                    EVENT_CONDITIONS.add((EventCondition) eventIdentifier);
                }
                break;
            case LISTENER:
                if(!EVENT_ATTRIBUTE_LISTENERS.contains(eventIdentifier)) {
                    EVENT_ATTRIBUTE_LISTENERS.add((EventAttributeListener) eventIdentifier);
                }
                break;
        }
    }
    default void unregister(AttributeType type, Identifiable eventIdentifier) {
        switch (type) {
            case ATTRIBUTE:
                EVENT_ATTRIBUTES.remove(eventIdentifier);
                break;
            case CONDITION:
                EVENT_CONDITIONS.remove(eventIdentifier);
                break;
            case LISTENER:
                EVENT_ATTRIBUTE_LISTENERS.remove(eventIdentifier);
                break;
        }
    }
}
