package io.github.rostikq.task01;


import io.github.rostikq.logger.Logger;

public class ShipmentType {
    private String typeName;
    private String icon;
    private String color;

    public ShipmentType(String typeName, String icon, String color) {
        this.typeName = typeName;
        this.icon = icon;
        this.color = color;
        Logger.log("ShipmentType", "Створено новий об'єкт типу відправлення: " + typeName);
    }

    public String getTypeName() { return typeName; }
    public String getIcon() { return icon; }
    public String getColor() { return color; }
}
