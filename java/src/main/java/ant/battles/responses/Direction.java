package ant.battles.responses;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Direction {

    private final List<Ant> ants;
    private final List<Food> foods;

    public Direction(List<Ant> ants, List<Food> foods) {

        this.ants = ants;
        this.foods = foods;
    }

    @JsonCreator
    public static Direction fromValue(List<Surroundable> things) {
        List<Ant> ants =  extract(things, AntMessage.class).stream().map(Ant::new).collect(toList());
        List<Food> foods = extract(things, Food.class);

        return new Direction(ants, foods);

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
