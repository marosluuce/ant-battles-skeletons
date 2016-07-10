package ant.battles.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeaveTest {

    @Test
    public void canBeDeserialized() throws Exception {
        String input = "{\"status\":\"ok\",\"message\":{\"removed\":1234}}";

        ObjectMapper mapper = new ObjectMapper();
        Leave food = mapper.readValue(input, Leave.class);

        assertThat(food.nestId()).isEqualTo(1234);
    }
}