public enum Value {
    SEVEN(1),
    EIGHT(2),
    NINE(3),
    TEN(4),
    J(5),
    Q(6),
    K(7),
    A(8);
    
    public final int strength;

    private Value(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}
