package Orders;

import Factories.OrderFactory;

public class OrderBuilder {
    private String type;

    public OrderBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Order build() {
        return OrderFactory.createOrder(type);
    }
}
