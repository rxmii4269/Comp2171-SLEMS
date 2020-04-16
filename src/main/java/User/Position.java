package User;

public enum Position {
    Supervisor("Supervisor"),
    Subordinate("Subordinate");

    private String position;

    Position(String position) {
        this.position = position;
    }

    public static Position findByName(String name) {
        Position[] var1 = values();
        int var2 = var1.length;

        for (Position pos : var1) {
            if (name.equalsIgnoreCase(pos.getPosition())) {
                return pos;
            }
        }

        return valueOf(Position.class, name);
    }

    public static boolean contains(String test) {
        Position[] var1 = values();
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