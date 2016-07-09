package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class Location {
    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @JsonCreator
    public static Location create(List<Integer> coordinates) {
        return new Location(coordinates.get(0),coordinates.get(1));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj instanceof Location) {
            Location other = (Location) obj;
            return this.x == other.x && this.y == other.y;
        }

        return false;
    }
}
