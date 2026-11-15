package io.github.rostikq.task01;

import java.util.HashMap;
import java.util.Map;

class ShipmentTypeFactory {
    private static final Map<String, ShipmentType> types = new HashMap<>();

    public static ShipmentType getType(String typeName, String icon, String color) {
        types.putIfAbsent(typeName, new ShipmentType(typeName, icon, color));
        return types.get(typeName);
    }

    public static int getTypesCount() {
        return types.size();
    }
}
