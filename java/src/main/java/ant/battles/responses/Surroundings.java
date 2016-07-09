package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Surroundings {

    private final Direction ne;
    private Direction n;

    @JsonCreator
    public Surroundings(@JsonProperty("ne") Direction ne,
                        @JsonProperty("n") Direction n) {
        this.ne = ne;
        this.n = n;
    }

    public Direction northEast() {
        return ne;
    }

    public Direction north() {
        return n;
    }

}
