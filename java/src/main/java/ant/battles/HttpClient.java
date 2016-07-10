package ant.battles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import java.util.Optional;

public class HttpClient {
    private final ObjectMapper mapper = new ObjectMapper();

    public Optional<String> getString(String url) {
        try {
            String raw = Unirest.get(url).asString().getBody();
            return Optional.of(raw);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public <T> Optional<T> get(String url, Class<T> valueType) {
        try {
            String raw = Unirest.get(url).asString().getBody();
            return Optional.of(mapper.readValue(raw, valueType));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}