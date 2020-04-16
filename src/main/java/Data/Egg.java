
package Data;

import java.time.format.DateTimeFormatter;

public class Egg {
    private DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
    private int EggCount;
    private String employeeID;
    private int numEggsCollected;
    private int numEggsBroken;
    private int numEggsSpoilt;

    Egg(DateTimeFormatter date) {
        this.date = date;
    }

    public Egg(String employeeID, DateTimeFormatter date, int numEggsCollected, int numEggsBroken, int numEggsSpoilt) {
        this.employeeID = employeeID;
        this.date = date;
        this.numEggsCollected = numEggsCollected;
        this.numEggsBroken = numEggsBroken;
        this.numEggsSpoilt = numEggsSpoilt;
    }

    Egg() {
    }

    public void currentEggSupply() {
    }

    public void editSupplyData() {
    }

    public void DeleteSupply() {
    }

    public DateTimeFormatter getDate() {
        return this.date;
    }

    public int getEggCount() {
        return this.EggCount;
    }

    public void setEggCount(int eggCount) {
        this.EggCount = eggCount;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getNumEggsCollected() {
        return this.numEggsCollected;
    }

    public void setNumEggsCollected(int numEggsCollected) {
        this.numEggsCollected = numEggsCollected;
    }

    public int getNumEggsBroken() {
        return this.numEggsBroken;
    }

    public void setNumEggsBroken(int numEggsBroken) {
        this.numEggsBroken = numEggsBroken;
    }

    public int getNumEggsSpoilt() {
        return this.numEggsSpoilt;
    }

    public void setNumEggsSpoilt(int numEggsSpoilt) {
        this.numEggsSpoilt = numEggsSpoilt;
    }
}
