package User;

import Security.Login_UserUI;
import UI.New_UserUI;

import java.io.IOException;
import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String employeeID;
    private long phoneNum;
    private String password;
    private String loginName;
    private User.Position position;
    private ArrayList<String> details = new ArrayList<>();

    public User() {
    }

    User(String employeeID, String firstName, String lastName, String emailAddress, long phoneNum, User.Position position) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.emailAddress = emailAddress;
        this.phoneNum = phoneNum;
    }

    public static void main(String[] args) {
        User user = new User();
        user.Login();
    }

    public User.Position getPosition() {
        return this.position;
    }

    public void setPosition(User.Position position) {
        this.position = position;
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

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public long getPhoneNumber() {
        return this.phoneNum;
    }

    public void setPhoneNumber(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String getLoginName() {
        return this.loginName;
    }

    public void setLoginName() {
        String var10001 = this.getFirstName();
        this.loginName = var10001 + this.getLastName();
    }

    private void newUser() throws IOException {
        New_UserUI addUser = new New_UserUI();
        addUser.getFrame().setVisible(true);
    }

    public void viewUser() {
        if (this.loginName.equalsIgnoreCase("Supervisor")) {
            System.out.println("Current user is " + this.getLoginName());
        } else if (this.getLoginName().equalsIgnoreCase("Subordinate")) {
            System.out.println("Current user is " + this.getLoginName());
        } else {
            System.err.println("THERE'S NO USER CURRENTLY ONLINE \\n\" + \"GOODBYE");
        }

    }

    private void Login() {
        Login_UserUI login = new Login_UserUI();
        login.getFrame().setVisible(true);
    }

    public ArrayList<String> getDetails() {
        return this.details;
    }

    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }

    public enum Position {
        Supervisor("Supervisor"),
        Subordinate("Subordinate");

        private String position;

        Position(String position) {
            this.position = position;
        }

        public static User.Position findByName(String name) {
            User.Position[] var1 = values();
            int var2 = var1.length;

            for (Position pos : var1) {
                if (name.equalsIgnoreCase(pos.getPosition())) {
                    return pos;
                }
            }

            return valueOf(Position.class, name);
        }

        public static boolean contains(String test) {
            User.Position[] var1 = values();
            int var2 = var1.length;

            for (Position p : var1) {
                if (p.name().equalsIgnoreCase(test)) {
                    return true;
                }
            }

            return false;
        }

        public String getPosition() {
            return this.position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}
