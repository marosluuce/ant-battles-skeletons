package ant.battles;

import ant.battles.responses.Ant;
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
        assertThat(client.join("Badgers").map(Nest::getTeam)).contains("Badgers");
    }

    @Test
    public void spawnsAfreshAnt() {
        Client client = new Client();
        Nest nest = client.join("Badgers").get();

        assertThat(client.spawnAntFor(nest).map(Ant::hasFood)).contains(false);
    }

    @Test
    public void movesAnAnt() {
        Client client = new Client();
        Nest nest = client.join("Badgers").get();

        Ant ant = client.spawnAntFor(nest).get();

        Optional<Ant> moved = client.move(ant, Direction.NORTH);

        System.out.println(moved.get().getLocation());

    }
}