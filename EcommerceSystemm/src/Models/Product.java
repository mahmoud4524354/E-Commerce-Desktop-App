package Models;

public abstract class Product {
    protected String name;

    public String getName() {
        return name;
    }

    public abstract void displayInfo();
}
