package Orders;

public class StandardOrder implements Order {
    @Override
    public void processOrder() {
        System.out.println("Processing Standard Order.");
    }
}
