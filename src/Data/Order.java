package Data;

import java.util.Date;
import java.util.Scanner;

public class Order {
    private static final int pCost = 600;
    private static final double GCT = 0.165D;
    private Date date;
    private OrderStatus status;
    private Customer cust;
    private long product;

    public Order(long product) {
        this.product = product;
    }

    Order() {
    }

    void placeOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the amount of 'SLEMS' liquid eggs the customer ordered");
        this.product = sc.nextInt();
        this.cust.customer.add(4, String.valueOf(this.product));
    }

    private long calcCost() {
        return (long)(this.getPCost() * (float)this.getProduct());
    }

    private long calcGCT() {
        return (long)((double)this.calcCost() * this.getGCT());
    }

    private double getGCT() {
        return GCT;
    }

    public long total() {
        return this.calcCost() + this.calcGCT();
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    private void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return this.date;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    private long getProduct() {
        return this.product;
    }

    void setProduct(long product) {
        this.product = product;
    }

    private float getPCost() {
        return (float)pCost;
    }

    public String toString() {
        long var10000 = this.total();
        return "Orders amount: $" + var10000 + OrderStatus.findByName("Active");
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }
}
