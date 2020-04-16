package Data;

class Payment {
    private double amount;
    private Customer customer;

    Payment(String type, float amount, Customer customer) {
        PaymentType pType = PaymentType.findByName(type);
        this.amount = amount;
        this.customer = customer;
    }

    public void makePayment() {
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
