package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ant")
public class AntMessage extends BaseMessage implements Surroundable {

    public String type = "ant";

    @JsonProperty
    public long nest;

    @JsonProperty
    public Location location;

    @JsonProperty("got_food")
    public boolean food;
}
