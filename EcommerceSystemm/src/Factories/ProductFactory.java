package Factories;

import Models.*;

public class ProductFactory {
    public static Product createProduct(String category) {
        switch (category) {
            case "Electronics":
                return new Electronics();
            case "Clothing":
                return new Clothing();
            case "Home Appliance":
                return new HomeAppliance();
            default:
                throw new IllegalArgumentException("Invalid product category");
        }
    }
}
