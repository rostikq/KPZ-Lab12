package io.github.rostikq.task03;

public class SingleItem implements CargoComponent {
    private String name;
    private double weight;
    private double value;

    public SingleItem(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public double getWeight() { return weight; }

    @Override
    public double getDeclaredValue() { return value; }

    @Override
    public int getItemsCount() { return 1; }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "- Відправлення: " + name + " | Вага: " + weight + " кг | Вартість: " + value + " грн");
    }
}
