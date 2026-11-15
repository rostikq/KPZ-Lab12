package io.github.rostikq.task01;

class ShipmentMarker {
    private String trackingNumber;
    private double latitude;
    private double longitude;
    private String status;
    private ShipmentType type;

    public ShipmentMarker(String trackingNumber, double latitude, double longitude, String status, ShipmentType type) {
        this.trackingNumber = trackingNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.type = type;
    }

    public ShipmentType getType() { return type; }

    public void printInfo() {
        System.out.println("Позначка [" + trackingNumber + "] | Тип: " + type.getTypeName() +
                " (Іконка: " + type.getIcon() + ", Колір: " + type.getColor() +
                ") | Координати: (" + latitude + ", " + longitude + ") | Статус: " + status);
    }
}
