package AnimalsP;

import AnimalsP.HerbivoresP.Duck;
import AnimalsP.HerbivoresP.Mouse;
import IslandP.Island;
import IslandP.Location;
import PlantP.Plant;
import org.junit.Test;

import static org.junit.Assert.*;

public class HerbivoreTest {

    @Test
    public void testHerbivoreAdd() {
        Location location = new Location();
        Herbivore Duck = new Duck(0,0);

        location.addAnimal(Duck);

        assertTrue(location.getAnimalList().contains(Duck));
    }

    @Test
    public void testHerbivoreEatPlant() {
        Location location = new Location();
        Herbivore Duck = new Duck(0, 0);
        Duck.energy = Duck.energy /2;

        Plant plant = new Plant();
        location.addPlant(plant);

        double en1 = Duck.energy;
        Duck.eat(location);
        double en2 = Duck.energy;

        assertFalse(location.getPlantList().contains(plant)); // Он испарился? так ведь?
        assertTrue( en2 > en1); // Бахнув энерджи
    }


    @Test
    public void testHerbivoreMovement() {
        Island island = new Island(10, 10);

        Herbivore Duck = new Duck(0, 0);

        island.getLocation(0,0).addAnimal(Duck);

        Duck.move(Duck.speed, island);

        // Животинка ушла(
         assertTrue(island.getLocation(5, 5).getAnimalList().isEmpty());

        // Проверка что животное не слишком сильно испарилось
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
    public void testHerbivoreDeath() {
        Location location = new Location();
        Herbivore Mouse = new Mouse(0, 0);
        Mouse.energy = 0;

        Mouse.die(location);

        assertFalse(location.getAnimalList().contains(Mouse));
    }

}
