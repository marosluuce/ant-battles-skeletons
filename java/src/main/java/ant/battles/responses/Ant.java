package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ant {

    private final String status;
    private final AntMessage message ;

    public Ant(AntMessage message) {
        this("ok", message);
    }

    @JsonCreator
    public Ant(@JsonProperty("status") String status,
               @JsonProperty("message") AntMessage message) {

        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
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

    public long getNest() {
        return message.nest;
    }

    public Location getLocation() {
        return message.location;
    }

    public boolean hasFood() {
        return message.food;
    }
}
