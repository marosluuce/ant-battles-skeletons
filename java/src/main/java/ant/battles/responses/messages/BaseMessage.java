package ant.battles.responses.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseMessage {

    @JsonProperty
    public String team;

    @JsonProperty
    public long id;

}
