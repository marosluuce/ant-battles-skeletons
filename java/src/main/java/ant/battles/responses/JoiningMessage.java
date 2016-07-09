package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JoiningMessage extends BaseMessage {

    @JsonProperty
    public String type;

    @JsonProperty
    public int food;

    @JsonProperty
    public int ants;

    @JsonProperty
    public Location location;

}
