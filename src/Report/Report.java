package Report;

import Data.ExternalEggSupplier;
import Data.ExternalEggSupply;
import Data.Order;
import Data.ProvisionalSupplyData;

import javax.swing.text.Position;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
    private DateTimeFormatter date = DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy HH:mm:ss");
    private final LocalDateTime now = LocalDateTime.now();
    private String employeeID;
    private ProvisionalSupplyData provisionalSupplyData;
    private final PrintWriter out;
    private final BufferedReader supplier;
    private final BufferedReader customer;
    private final BufferedReader product;
    private Position position;

    public Report() throws IOException {
        FileWriter writeTable = new FileWriter("Report.txt", StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(writeTable);
        this.out = new PrintWriter(bw);
        this.supplier = new BufferedReader(new FileReader("Supplier Info.txt"));
        this.customer = new BufferedReader(new FileReader("Customer Info.txt"));
        this.product = new BufferedReader(new FileReader("Product.txt"));
    }

    public void generateReport() throws IOException {
        this.out.println("Created by Supervisor ");
        this.out.println("Compiled on: " + this.getDate().format(this.now) + "\n\n");

        String count;
        while((count = this.supplier.readLine()) != null) {
            this.out.println(count);
        }

        this.out.println("\n");

        while((count = this.customer.readLine()) != null) {
            this.out.println(count);
        }

        this.out.println("\n");

        while((count = this.product.readLine()) != null) {
            this.out.println(count);
        }

        this.out.flush();
        this.out.close();
        this.supplier.close();
    }

    private DateTimeFormatter getDate() {
        return this.date;
    }

    public void setDate(DateTimeFormatter date) {
        this.date = date;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public ProvisionalSupplyData getProvisionalSupplyData() {
        return this.provisionalSupplyData;
    }

    public void setProvisionalSupplyData(ProvisionalSupplyData provisionalSupplyData) {
        this.provisionalSupplyData = provisionalSupplyData;
    }

    public void setExternalEggSupplier(ExternalEggSupplier externalEggSupplier) {
    }

    public void setExternalEggSupply(ExternalEggSupply externalEggSupply) {
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setOrder(Order order) {
    }
}
