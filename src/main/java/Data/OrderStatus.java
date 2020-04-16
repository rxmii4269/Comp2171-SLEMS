package Data;

public enum OrderStatus {
    Closed("Closed"),
    Delivered("Delivered"),
    New("New"),
    OnHold("onHold");

    private String name;

    OrderStatus(String name) {
        this.name = name;
    }

    public static OrderStatus findByName(String name) {
        OrderStatus[] var1 = values();
        for (OrderStatus o : var1) {
            if (name.equalsIgnoreCase(o.getName())) {
                return o;
            }
        }

        return valueOf(OrderStatus.class, name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
