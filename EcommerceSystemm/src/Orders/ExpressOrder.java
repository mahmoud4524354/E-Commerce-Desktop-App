package Orders;

public class ExpressOrder implements Order {
    @Override
    public void processOrder() {
        System.out.println("Processing Express Order.");
    }
}
