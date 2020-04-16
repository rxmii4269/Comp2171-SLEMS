package Data;

import java.util.ArrayList;
import java.util.Scanner;

public class ExternalEggSupplier {
    private String companyName;
    private String farmAddress;
    private String phoneNum;
    public ArrayList<String> externalEggSupplier = new ArrayList<>();
    private final Scanner input;

    ExternalEggSupplier(String companyName, String farmAddress, String phoneNum) {
        this.input = new Scanner(System.in);
        this.companyName = companyName;
        this.farmAddress = farmAddress;
        this.phoneNum = phoneNum;
    }

    public ExternalEggSupplier() {
        this.input = new Scanner(System.in);
    }

    public void newExternalSupplier() {
        System.out.println("Enter the Following Details of the new External Supplier ");
        System.out.println("Company Name");
        this.companyName = this.input.nextLine();
        System.out.println("Farm's Address");
        this.farmAddress = this.input.nextLine();
        System.out.println("Phone Number");
        this.phoneNum = this.input.nextLine();
        ExternalEggSupply Egg = new ExternalEggSupply();
        Egg.enterEggSupply();
        this.externalEggSupplier.add(this.getCompanyName());
        this.externalEggSupplier.add(this.getFarmAddress());
        this.externalEggSupplier.add(this.getPhoneNum());
        this.externalEggSupplier.add(String.valueOf(Egg.getNumEggsSupplied()));
    }

    public void viewExternalSupplier() {
        System.out.println("Current External Supplier is " + this.getCompanyName());
    }

    public void editExternalSupplier() {
        System.out.println("Press [C]ompany Name [F]arm Address [P]hone Number ");
        String val = this.input.nextLine().toUpperCase();
        switch(val.charAt(0)) {
            case 'C':
                String c = this.externalEggSupplier.get(0);
                System.out.println("Enter the new Company Name");
                this.externalEggSupplier.add(0, this.input.nextLine());
                System.out.println("Name has been changed successfully from " + c + " to " + this.externalEggSupplier.get(0));
                break;
            case 'F':
                String f = this.externalEggSupplier.get(1);
                System.out.println("Enter the new Address");
                this.externalEggSupplier.add(1, this.input.nextLine());
                System.out.println("Address has been successfully changed from " + f + " to " + this.externalEggSupplier.get(1));
                break;
            case 'P':
                String p = this.externalEggSupplier.get(2);
                System.out.println("Enter the new Phone Number");
                this.externalEggSupplier.add(2, this.input.nextLine());
                System.out.println("Phone Number has been changed successfully from " + p + " to " + this.externalEggSupplier.get(2));
                break;
            default:
                System.out.println("Incorrect value picked");
        }

    }

    public void deleteExternalSupplier() {
        this.externalEggSupplier.clear();
        System.out.println("External Supplier is deleted");
    }

    private String getFarmAddress() {
        return this.farmAddress;
    }

    public void setFarmAddress(String farmAddress) {
        this.farmAddress = farmAddress;
    }

    private String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (String value : this.externalEggSupplier) {
            builder.append(value).append(" ");
        }

        return "External Egg Suppliers:\n " + builder.toString();
    }
}
