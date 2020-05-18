package Data;

import View.UI.Enter_DataUI;

class Product {
    private Enter_DataUI Data;
    private int usableEggs;

    Product() {
    }

    public int calcUsableEggs() {
        int eggsCollected = this.Data.getEggsCollected();
        int eggsSpoiled = this.Data.getEggsSpoiled();
        int eggsBroken = this.Data.getEggsBroken();
        this.usableEggs -= eggsSpoiled + eggsBroken;
        if (eggsBroken + eggsSpoiled > eggsCollected) {
            System.out.println("Cannot produce enough Liquid Eggs");
        }

        return this.usableEggs;
    }

    private int calcUsableProducts() {
        if (this.usableEggs == 0) {
            System.out.println("Cannot Make Enough Products Purchase from a External Supplier\n");
        }

        return this.usableEggs / 2;
    }

    public int getUsableEggs() {
        return this.usableEggs;
    }

    public void setUsableEggs(int usableEggs) {
        this.usableEggs = usableEggs;
    }

    public Enter_DataUI getData() {
        return this.Data;
    }

    public void setData(Enter_DataUI data) {
        this.Data = data;
    }

    public String toString() {
        return "Products\n" + this.calcUsableProducts();
    }
}
