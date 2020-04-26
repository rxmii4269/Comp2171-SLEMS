package User;

import Database.DB_Main;

import java.sql.ResultSet;
import java.sql.SQLException;


public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String id;
    private long phoneNum;
    private String username;
    private String password;
    public User() {
    }

    User(String id, String firstName, String lastName, String emailAddress, long phoneNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNum = phoneNum;
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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    String getUsername() {
        return this.username;
    }

    public void setLoginName() {
        String var10001 = this.getFirstName();
        this.username = var10001 + this.getLastName();
    }

    public void viewUser() {
        if (this.username.equalsIgnoreCase("Supervisor")) {
            System.out.println("Current user is " + this.getUsername());
        } else if (this.getUsername().equalsIgnoreCase("Subordinate")) {
            System.out.println("Current user is " + this.getUsername());
        } else {
            System.err.println("THERE'S NO USER CURRENTLY ONLINE \\n\" + \"GOODBYE");
        }

    }

    public void Login(String username,String password) {
        try{
            DB_Main db = new DB_Main();
            String[] columns={"username","password"};
            Object[] params = {username};
           ResultSet rs = db.select("employees",columns,"username= ?",params);
           while (rs.next()){
               System.out.println(rs.getString("username")+ " - "+rs.getString("password"));
           }

        }catch (SQLException e){
            System.out.println("error - " + e.getMessage());
        }
    }

}
