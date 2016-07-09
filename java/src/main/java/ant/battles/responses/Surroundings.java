package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Surroundings {

    private final Environment ne;
    private Environment n;

    @JsonCreator
    public Surroundings(@JsonProperty("ne") Environment ne,
                        @JsonProperty("n") Environment n) {
        this.ne = ne;
        this.n = n;
    }

    public Environment northEast() {
        return ne;
    }

    public Environment north() {
        return n;
    }

}
