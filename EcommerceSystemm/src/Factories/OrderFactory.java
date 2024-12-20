package Factories;

import Orders.*;

public class OrderFactory {
    public static Order createOrder(String type) {
        switch (type) {
            case "Standard":
                return new StandardOrder();
            case "Express":
                return new ExpressOrder();
            default:
                throw new IllegalArgumentException("Invalid order type");
        }
    }
}
