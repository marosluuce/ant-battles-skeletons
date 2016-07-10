package ant.battles.responses;

import ant.battles.Direction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

import static ant.battles.Direction.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Surroundings {

    private final Map<Direction, Environment> environments = new HashMap<>();

    @JsonCreator
    public Surroundings(@JsonProperty("n") Environment n,
                        @JsonProperty("ne") Environment ne,
                        @JsonProperty("e") Environment e,
                        @JsonProperty("se") Environment se,
                        @JsonProperty("s") Environment s,
                        @JsonProperty("sw") Environment sw,
                        @JsonProperty("w") Environment w,
                        @JsonProperty("nw") Environment nw){
        environments.put(NORTH, n);
        environments.put(NORTH_EAST, ne);
        environments.put(EAST, e);
        environments.put(SOUTH_EAST, se);
        environments.put(SOUTH, s);
        environments.put(SOUTH_WEST, sw);
        environments.put(WEST, w);
        environments.put(NORTH_WEST, nw);
    }

    public Environment environment(Direction direction) {
        return environments.get(direction);
    }
}
