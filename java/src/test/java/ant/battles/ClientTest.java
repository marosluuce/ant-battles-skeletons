package ant.battles;

import ant.battles.responses.Ant;
import ant.battles.responses.Leave;
import ant.battles.responses.Location;
import ant.battles.responses.Nest;
import org.junit.Test;

import javax.swing.text.AbstractDocument;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {
    private final Client client = new Client("http://localhost:4000");

    @Test
    public void hitsTheRoot() {
        assertThat(client.root()).contains("Welcome to Ant Battles!");
    }

    @Test
    public void createsAndLeavesTeam() {
        Nest nest = client.join("Badgers").get();
        assertThat(nest.getTeam()).isEqualTo("Badgers");
        Leave leave = client.leave(nest).get();
        assertThat(leave.nestId()).isEqualTo(nest.getId());
    }

    @Test
    public void spawnsAfreshAnt() {
        Nest nest = client.join("Badgers").get();

        assertThat(client.spawnAntFor(nest).map(Ant::hasFood)).contains(false);
        client.leave(nest);
    }

    @Test
    public void movesAnAnt() {
        Nest nest = client.join("Badgers").get();

        Ant ant = client.spawnAntFor(nest).get();

        Optional<Ant> moved = client.move(ant, Direction.NORTH);

        assertThat(moved.map(Ant::getLocation).get()).isEqualTo(new Location(0,1));
        client.leave(nest);
    }

    @Test
    public void lookAround() {
        Nest nest = client.join("Badgers").get();

        Ant ant = client.spawnAntFor(nest).get();

        Optional<Ant> moved = client.look(ant);

        assertThat(moved.map(Ant::getLocation).get()).isEqualTo(new Location(0,0));

        client.leave(nest);
    }
}