package View.User;

import java.io.Serializable;

public class Supervisor extends User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2701149358413516598L;
    private static String firstName;
    private static String lastName;
    private static String employeeID;
    private static String emailAddress;
    private static int phoneNumber;
    private static volatile Supervisor soleInstance;

    private Supervisor(String firstName, String lastName, String employeeID, String emailAddress, int phoneNumber) {
        super(employeeID, firstName, lastName, emailAddress, phoneNumber);
        Supervisor.firstName = firstName;
        Supervisor.lastName = lastName;
        Supervisor.employeeID = employeeID;
        Supervisor.emailAddress = emailAddress;
        Supervisor.phoneNumber = phoneNumber;
        if (getSoleInstance() != null) {
            throw new RuntimeException("Use the getInstance() method to get the single instance of this class.");
        }
    }

    public static Supervisor getInstance() {
        if (getSoleInstance() == null) {
            synchronized (Supervisor.class) {
                if (getSoleInstance() == null) {
                    setSoleInstance(new Supervisor(firstName, lastName, employeeID, emailAddress, phoneNumber));
                }
            }
        }

        return getSoleInstance();
    }

    private static Supervisor getSoleInstance() {
        return soleInstance;
    }

    private static void setSoleInstance(Supervisor soleInstance) {
        Supervisor.soleInstance = soleInstance;
    }

    protected Supervisor readResolve() {
        return getInstance();
    }
}
