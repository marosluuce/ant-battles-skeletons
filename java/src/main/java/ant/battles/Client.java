package ant.battles;

import ant.battles.responses.Ant;
import ant.battles.responses.Nest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import java.util.Optional;

public class Client {
    private final String url = "http://localhost:4000";
    private final ObjectMapper mapper = new ObjectMapper();

    public Optional<String> root() {
        return getString(url);
    }

    public Optional<Nest> join(String name) {
        return get(this.url + "/join/" + name, Nest.class);
    }

    public Optional<Ant> spawnAntFor(Nest nest) {
        return get(this.url + "/" + nest.getId() + "/spawn", Ant.class);
    }

    public Optional<Ant> move(Ant ant, Direction north) {
        return get(this.url + "/" + ant.getId() + "/move/" + north.code(), Ant.class);
    }


    public Optional<Ant> look(Ant ant) {
        return get(url + "/" +ant.getId()+"/look", Ant.class);
    }

    public Optional<String> leave(Nest nest) {
        return getString(this.url + "/" + nest.getId() + "/leave");
    }

    private Optional<String> getString(String url) {
        try {
            String raw = Unirest.get(url).asString().getBody();
            return Optional.of(raw);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private <T> Optional<T> get(String url, Class<T> valueType) {
        try {
            String raw = Unirest.get(url).asString().getBody();
            return Optional.of(mapper.readValue(raw, valueType));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
