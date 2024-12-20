package Payment;

public class NewPaymentProcessorImpl implements NewPaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("Processing payment using the new system: " + amount);
    }
}
