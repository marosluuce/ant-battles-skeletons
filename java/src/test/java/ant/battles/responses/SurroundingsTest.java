package ant.battles.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SurroundingsTest {

    @Test
    public void mixedContent() throws IOException {
        String input = "{\"w\":[],\"sw\":[],\"se\":[],\"s\":[],\"nw\":[],\"ne\":[{\"type\":\"ant\",\"team\":\"me\",\"nest\":2,\"location\":[1,1],\"id\":2,\"got_food\":false}],\"n\":[{\"type\":\"food\",\"quantity\":1,\"location\":[0,1]}],\"e\":[]}";

        ObjectMapper mapper = new ObjectMapper();
        Surroundings surroundings = mapper.readValue(input, Surroundings.class);

        List<Ant> northeastern = surroundings.northEast().ants();
        List<Food> foods = surroundings.north().foods();

        assertThat(northeastern.get(0).getId()).isEqualTo(2);
        assertThat(foods.get(0).quantity).isEqualTo(1);
    }
}