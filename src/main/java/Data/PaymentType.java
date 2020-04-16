package Data;

public enum PaymentType {
    cash("Cash Account"),
    check("Check Account"),
    credit("credit Account");

    private final String longName;

    PaymentType(String name) {
        this.longName = name;
    }

    public static PaymentType findByName(String name) {
        PaymentType[] var1 = values();
        for (PaymentType at : var1) {
            if (name.equalsIgnoreCase(at.getLongName())) {
                return at;
            }
        }

        return valueOf(PaymentType.class, name);
    }

    public String getLongName() {
        return this.longName;
    }
}
