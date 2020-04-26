package User;

public class FactoryWorker extends User {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;

    public FactoryWorker(String employeeID, String firstName, String lastName, String emailAddress, long phoneNumber) {
        super(employeeID, firstName, lastName, emailAddress, phoneNumber);
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return this.employeeID;
    }

    public void setId(String id) {
        this.employeeID = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        String var10000 = this.getUsername();
        return "Welcome Employee " + var10000 + this.getId();
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = (long)phoneNumber;
    }
}
