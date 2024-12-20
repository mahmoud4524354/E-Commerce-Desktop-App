package Payment;

public class PaymentAdapter {
    private NewPaymentProcessor processor;

    public PaymentAdapter(NewPaymentProcessor processor) {
        this.processor = processor;
    }

    public void processOldPayment(double amount) {
        processor.process(amount);
    }
}
