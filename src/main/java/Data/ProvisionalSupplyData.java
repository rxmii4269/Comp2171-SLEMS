package Data;

import java.time.format.DateTimeFormatter;

public class ProvisionalSupplyData extends Egg {
    public ProvisionalSupplyData(String employeeID, DateTimeFormatter date, int numEggsCollected, int numEggsBroken, int numEggsSpoilt, int workStationNumber, int workStationSect) {
        super(employeeID, date, numEggsCollected, numEggsBroken, numEggsSpoilt);
    }

    public String enterProvisionalData() {
        return null;
    }

    public void editSupplyData() {
    }

    public void DeleteSupply() {
    }

    public void currentEggSupply() {
    }
}
