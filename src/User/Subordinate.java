package User;

public class Subordinate extends User {
    private String employeeID;
    private String firstName;
    private String lastName;
    private Position position;
    private String emailAddress;
    private long phoneNumber;

    public Subordinate(String employeeID, String firstName, String lastName, String emailAddress, long phoneNumber, Position position) {
        super(employeeID, firstName, lastName, emailAddress, phoneNumber, Position.Subordinate);
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String toString() {
        String var10000 = this.getLoginName();
        return "Welcome Employee " + var10000 + this.getEmployeeID() + this.getPosition();
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
