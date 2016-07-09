package ant.battles.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodTest {

    @Test
    public void canBeDeserialized() throws IOException {
        String input = "{\"type\":\"food\",\"quantity\":1,\"location\":[0,1]}";

        ObjectMapper mapper = new ObjectMapper();
        Food food = mapper.readValue(input, Food.class);

        assertThat(food.quantity).isEqualTo(1);
        assertThat(food.location).isEqualTo(new Location(0,1));
    }
}