package Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Customer {
    public ArrayList<String> customer = new ArrayList<>();
    private String customerName;
    private String phoneNum;
    private String deliveryAddress;
    private String active;
    private final FileWriter writeTable;
    private final BufferedWriter bw;
    private final PrintWriter out;
    private String emailAddress;
    private int amt;
    
    Customer(String customerName, String phoneNum, String deliveryAddress, String active) throws IOException {
        this.writeTable = new FileWriter("Customer Info.txt", StandardCharsets.UTF_8, true);
        this.bw = new BufferedWriter(this.writeTable);
        this.out = new PrintWriter(this.bw);
        new Order();
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.deliveryAddress = deliveryAddress;
        this.active = active;
    }

    public Customer(String custName, String phoneNum, String address, String email, int amt) throws IOException {
        this.writeTable = new FileWriter("Customer Info.txt", StandardCharsets.UTF_8, true);
        this.bw = new BufferedWriter(this.writeTable);
        this.out = new PrintWriter(this.bw);
        new Order();
        this.customerName = custName;
        this.phoneNum = phoneNum;
        this.deliveryAddress = address;
        this.emailAddress = email;
        this.amt = amt;
    }

    public void customerInfo() {
        String formatStr = "%-30s %-30s %-30s %-30s %-30s %-25s%n";
        this.out.print(String.format(formatStr, "Customer Name", "Customer Phone Number", "Delivery Address", "Email Address", "Order Quantity", "Cost"));
        Order order = new Order(this.getAmt());
        this.out.print(String.format(formatStr, this.getCustomerName(), this.getPhoneNum(), this.getDeliveryAddress(), this.getEmailAddress(), this.getAmt(), order.total()));
        this.out.close();
    }

    private String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    private String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Object o : this.customer) {
            String value = (String) o;
            builder.append(value).append(" ");
        }

        return "Customer Data:\n " + builder.toString();
    }

    private String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private int getAmt() {
        return this.amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }
}
