package ant.battles;

public enum Direction {
    NORTH("n"),
    NORTH_EAST("ne"),
    EAST("e"),
    SOUTH_EAST("se"),
    SOUTH("s"),
    SOUTH_WEST("sw"),
    WEST("w"),
    NORTH_WEST("nw");

    private final String shorthand;

    Direction(String shorthand) {
        this.shorthand = shorthand;
    }

    public String code() {
        return this.shorthand;
    }
}
