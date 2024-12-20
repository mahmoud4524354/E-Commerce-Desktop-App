package Models;

public class HomeAppliance extends Product {
    public HomeAppliance() {
        this.name = "Home Appliance Product";
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a Home Appliance Product.");
    }
}
