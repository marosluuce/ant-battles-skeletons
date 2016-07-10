package ant.battles;

import ant.battles.responses.Ant;
import ant.battles.responses.Nest;

import java.util.Optional;

public class Client {
    private final String url;
    private final HttpClient httpClient = new HttpClient();

    public Client(String url) {
        this.url = url;
    }

    public Optional<String> root() {
        return httpClient.getString(url);
    }

    public Optional<Nest> join(String name) {
        return httpClient.get(this.url + "/join/" + name, Nest.class);
    }

    public Optional<Ant> spawnAntFor(Nest nest) {
        return httpClient.get(this.url + "/" + nest.getId() + "/spawn", Ant.class);
    }

    public Optional<Ant> move(Ant ant, Direction north) {
        return httpClient.get(this.url + "/" + ant.getId() + "/move/" + north.code(), Ant.class);
    }


    public Optional<Ant> look(Ant ant) {
        return httpClient.get(url + "/" + ant.getId() + "/look", Ant.class);
    }

    public Optional<String> leave(Nest nest) {
        return httpClient.getString(this.url + "/" + nest.getId() + "/leave");
    }
}
