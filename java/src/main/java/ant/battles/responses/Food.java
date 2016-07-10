package ant.battles.responses;

import ant.battles.responses.messages.Surroundable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Food implements Surroundable {

    @JsonProperty
    public int quantity;

    @JsonProperty
    public Location location;
}
