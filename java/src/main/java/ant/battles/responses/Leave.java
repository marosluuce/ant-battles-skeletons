package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Leave {

    @JsonProperty
    public String status;

    @JsonProperty
    private Removal message;

    public long nestId() {
        return message.removed;
    }

    @JsonSerialize
    public static class Removal {
        @JsonProperty
        public long removed;
    }
}
