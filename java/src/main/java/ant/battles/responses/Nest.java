package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Nest {

    public String getStatus() {
        return status;
    }

    private final String status;
    private final JoiningMessage message;

    @JsonCreator
    public Nest(@JsonProperty("status") String status,
                @JsonProperty("message") JoiningMessage message) {
        this.status = status;
        this.message = message;
    }

    public String getTeam() {
        return message.team;
    }

    public String getType() {
        return message.type;
    }

    public long getId() {
        return message.id;
    }

    public int getFood() {
        return message.food;
    }

    public int getAnts() {
        return message.ants;
    }

    public Location getLocation() {
        return message.location;
    }
}
