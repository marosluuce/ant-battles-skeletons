package ant.battles.responses;

import ant.battles.Direction;
import ant.battles.responses.messages.AntMessage;
import ant.battles.responses.messages.Surroundable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static ant.battles.Direction.*;
import static java.util.stream.Collectors.toList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Surroundings {

    private final Map<Direction, Environment> environments = new HashMap<>();

    @JsonCreator
    public Surroundings(@JsonProperty("n") Environment n,
                        @JsonProperty("ne") Environment ne,
                        @JsonProperty("e") Environment e,
                        @JsonProperty("se") Environment se,
                        @JsonProperty("s") Environment s,
                        @JsonProperty("sw") Environment sw,
                        @JsonProperty("w") Environment w,
                        @JsonProperty("nw") Environment nw){
        environments.put(NORTH, n);
        environments.put(NORTH_EAST, ne);
        environments.put(EAST, e);
        environments.put(SOUTH_EAST, se);
        environments.put(SOUTH, s);
        environments.put(SOUTH_WEST, sw);
        environments.put(WEST, w);
        environments.put(NORTH_WEST, nw);
    }

    public Environment environment(Direction direction) {
        return environments.get(direction);
    }

    public static class Environment {

        private final List<Ant> ants;
        private final List<Food> foods;

        public Environment(List<Ant> ants, List<Food> foods) {

            this.ants = ants;
            this.foods = foods;
        }

        @JsonCreator
        public static Environment fromValue(List<Surroundable> things) {
            List<Ant> ants =  extract(things, AntMessage.class).stream().map(Ant::new).collect(toList());
            List<Food> foods = extract(things, Food.class);

            return new Environment(ants, foods);

        }

        private static <T> List<T>  extract(List<Surroundable> things, Class<T> target) {
            return things.stream().filter(castable(target)).map(target::cast).collect(toList());
        }

        private static <T> Predicate<Surroundable> castable(Class<T> target) {
            return x -> target.isAssignableFrom(x.getClass());
        }

        public List<Ant> ants() {
            return ants;
        }

        public List<Food> foods() {
            return foods;
        }
    }
}
