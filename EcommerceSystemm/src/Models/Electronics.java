package Models;

public class Electronics extends Product {
    public Electronics() {
        this.name = "Electronics Product";
    }

    @Override
    public void displayInfo() {
        System.out.println("This is an Electronics Product.");
    }
}
