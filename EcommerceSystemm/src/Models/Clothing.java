package Models;

public class Clothing extends Product {
    public Clothing() {
        this.name = "Clothing Product";
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a Clothing Product.");
    }
}
