package ant.battles;

import ant.battles.responses.Ant;
import ant.battles.responses.Location;
import ant.battles.responses.Nest;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {

    @Test
    public void hitsTheRoot() {
        Client client = new Client();
        assertThat(client.root()).contains("Welcome to Ant Battles!");
    }

    @Test
    public void createsATeam() {
        Client client = new Client();
        Nest nest = client.join("Badgers").get();
        assertThat(nest.getTeam()).isEqualTo("Badgers");
        client.leave(nest);
    }

    @Test
    public void spawnsAfreshAnt() {
        Client client = new Client();
        Nest nest = client.join("Badgers").get();

        assertThat(client.spawnAntFor(nest).map(Ant::hasFood)).contains(false);
        client.leave(nest);
    }

    @Test
    public void movesAnAnt() {
        Client client = new Client();
        Nest nest = client.join("Badgers").get();

        Ant ant = client.spawnAntFor(nest).get();

        Optional<Ant> moved = client.move(ant, Direction.NORTH);

        assertThat(moved.map(Ant::getLocation).get()).isEqualTo(new Location(0,1));
        client.leave(nest);
    }

    @Test
    public void lookAround() {
        Client client = new Client();
        Nest nest = client.join("Badgers").get();

        Ant ant = client.spawnAntFor(nest).get();

        Optional<Ant> moved = client.look(ant);

        assertThat(moved.map(Ant::getLocation).get()).isEqualTo(new Location(0,0));

        client.leave(nest);
    }
}