package AnimalsP;

import AnimalsP.HerbivoresP.Mouse;
import AnimalsP.PredatorsP.Fox;
import AnimalsP.PredatorsP.Wolf;
import IslandP.Island;
import IslandP.Location;
import org.junit.Test;

import static org.junit.Assert.*;

public class PredatorTest {

    @Test
    public void testPredatorAdd() {
        Location location = new Location();
        Predator Wolf = new Wolf(0, 0);

        location.addAnimal(Wolf);

        assertTrue(location.getAnimalList().contains(Wolf));
        location.removeAnimal(Wolf);
    }

    @Test
    public void testPredatorEat() {
        Location location = new Location();
        Predator Fox = new Fox(0, 0);
        Fox.energy = Fox.energy / 2;
        Herbivore Mouse = new Mouse(0, 0);

        location.addAnimal(Mouse);

        double en1 = Fox.energy;
        Fox.eat(location);
        double en2 = Fox.energy;

        // схавали?
        assertFalse(location.getAnimalList().contains(Mouse));
        assertTrue(en2 > en1);
    }

    @Test
    public void testPredatorMovement() {
        Island island = new Island(10, 10);


        Predator Wolf = new Wolf(5, 5);
        Wolf.move(Wolf.speed, island);

        // кто куда а он ушел.
        assertTrue(island.getLocation(5, 5).getAnimalList().isEmpty());

        // куда ушел то?
        boolean moved = false;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (island.getLocation(x, y).getAnimalList().isEmpty()) {

                } else{
                    moved = true;
                    break;
                }
            }
        }
        assertTrue(moved);
    }

    @Test
    public void testPredatorDeath() {
        Location location = new Location();
        Predator Wolf = new Wolf(0, 0); // Устаф(
        Wolf.energy = 0;
        Wolf.die(location);

        // на пенсию
        assertFalse(location.getAnimalList().contains(Wolf));
    }


}
