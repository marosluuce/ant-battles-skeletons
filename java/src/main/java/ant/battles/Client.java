package ant.battles;

import ant.battles.responses.Ant;
import ant.battles.responses.Nest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Optional;

public class Client {
    private final String url = "http://localhost:4000";
    private final ObjectMapper mapper = new ObjectMapper();

    public Optional<String> root() {
        try {
            return Optional.of(Unirest.get(url).asString().getBody());
        } catch (UnirestException e) {
            return Optional.empty();
        }
    }

    public Optional<Nest> join(String name) {
        try {
            String raw = Unirest.get(url + "/join/"+name).asString().getBody();
            return Optional.of(mapper.readValue(raw, Nest.class));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Ant> spawnAntFor(Nest nest) {
        try {
            String raw = Unirest.get(url + "/"+nest.getId() + "/spawn").asString().getBody();
            Ant ant = mapper.readValue(raw, Ant.class);
            return Optional.of(ant);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
