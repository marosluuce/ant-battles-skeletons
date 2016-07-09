package ant.battles.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class AntTest {

    @Test
    public void convertsFromJSON() throws IOException {
        String from = "{\"status\":\"ok\",\"message\":{\"type\":\"ant\",\"team\":\"Badgers\",\"surroundings\":{\"w\":[],\"sw\":[],\"se\":[],\"s\":[],\"nw\":[],\"ne\":[],\"n\":[],\"e\":[]},\"nest\":146,\"location\":[0,0],\"id\":14,\"got_food\":true}}]";

        ObjectMapper mapper = new ObjectMapper();
        Ant ant = mapper.readValue(from, Ant.class);

        assertThat(ant.getStatus()).isEqualTo("ok");
        assertThat(ant.getTeam()).isEqualTo("Badgers");
        assertThat(ant.getType()).isEqualTo("ant");
        assertThat(ant.getId()).isEqualTo(14);
        assertThat(ant.getNest()).isEqualTo(146);
        assertThat(ant.getLocation()).isEqualTo(new Location(0,0));
        assertThat(ant.hasFood()).isTrue();
    }
}
