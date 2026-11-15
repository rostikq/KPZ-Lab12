package io.github.rostikq.task03;

import java.util.ArrayList;
import java.util.List;

public class CargoGroup implements CargoComponent {
    private String groupName;
    private List<CargoComponent> children = new ArrayList<>();

    public CargoGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(CargoComponent component) {
        children.add(component);
    }

    public void remove(CargoComponent component) {
        children.remove(component);
    }

    @Override
    public double getWeight() {
        double totalWeight = 0;
        for (CargoComponent c : children) {
            totalWeight += c.getWeight();
        }
        return totalWeight;
    }

    @Override
    public double getDeclaredValue() {
        double totalValue = 0;
        for (CargoComponent c : children) {
            totalValue += c.getDeclaredValue();
        }
        return totalValue;
    }

    @Override
    public int getItemsCount() {
        int count = 0;
        for (CargoComponent c : children) {
            count += c.getItemsCount();
        }
        return count;
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "+ Група [" + groupName + "] | Загальна вага: " + getWeight() +
                " кг | Вартість: " + getDeclaredValue() + " грн | Вкладень: " + getItemsCount());
        for (CargoComponent c : children) {
            c.printTree(indent + "  ");
        }
    }
}
