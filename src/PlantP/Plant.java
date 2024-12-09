package PlantP;

import IslandP.Location;

public class Plant {
    protected double weight = 1;
    protected int maxOnCell = 200;



    
    public void reproduce(Location location) {
        while (location.getPlantList().size() < maxOnCell) {
            location.addPlant(new Plant());
        }
    }
}
