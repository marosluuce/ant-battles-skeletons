package ant.battles.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class NestTest {

    @Test
    public void deserializesCorrectly() throws Exception {
        String json = "{\"status\":\"ok\",\"message\":{\"type\":\"nest\",\"team\":\"Badgers\",\"location\":[0,0],\"id\":14674,\"food\":5,\"ants\":0}}]";

        ObjectMapper mapper = new ObjectMapper();
        Nest nest = mapper.readValue(json, Nest.class);

        assertThat(nest.getStatus()).isEqualTo("ok");
        assertThat(nest.getTeam()).isEqualTo("Badgers");
        assertThat(nest.getType()).isEqualTo("nest");
        assertThat(nest.getId()).isEqualTo(14674);

        assertThat(nest.getFood()).isEqualTo(5);
        assertThat(nest.getAnts()).isEqualTo(0);
        assertThat(nest.getLocation()).isEqualTo(new Location(0,0));
    }
}