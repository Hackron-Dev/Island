package PlantP;

import IslandP.Location;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlantTest {

    @Test
    public void testAddPlant() {
        Location location = new Location();
        Plant plant = new Plant();

        location.addPlant(plant);


        assertTrue(location.getPlantList().contains(plant));
    }

    @Test
    public void testRemovePlant() {
        Location location = new Location();
        Plant plant = new Plant();

        location.addPlant(plant);
        location.removePlant(plant);

        assertFalse(location.getPlantList().contains(plant));
    }
}
