package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseMessage {

    @JsonProperty
    public String team;

    @JsonProperty
    public long id;

}
