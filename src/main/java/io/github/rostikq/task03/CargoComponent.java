package io.github.rostikq.task03;

public interface CargoComponent {
    double getWeight();
    double getDeclaredValue();
    int getItemsCount();
    void printTree(String indent);
}
