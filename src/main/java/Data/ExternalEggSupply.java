package Data;

import java.util.Scanner;

public class ExternalEggSupply extends Egg {
    private int numEggsSupplied = 0;
    private String supplier;

    public ExternalEggSupply(String numEggsSupplied) {
        this.numEggsSupplied = Integer.parseInt(numEggsSupplied);
    }

    ExternalEggSupply() {
    }

    public int currentExternalEggSupply() {
        return this.getNumEggsSupplied();
    }

    public void editSupplyData() {
        System.out.println("Current amount of eggs are:" + this.numEggsSupplied);
    }

    void enterEggSupply() {
        System.out.println("Enter the amount of eggs acquired from the supplier");
        Scanner input = new Scanner(System.in);
        this.numEggsSupplied = input.nextInt();
        input.close();
    }

    int getNumEggsSupplied() {
        return this.numEggsSupplied;
    }

    public String getSupplier() {
        return this.supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String toString() {
        return "External Egg Supply \n" + this.getNumEggsSupplied();
    }
}
