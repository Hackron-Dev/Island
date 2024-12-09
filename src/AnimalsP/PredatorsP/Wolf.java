package AnimalsP.PredatorsP;

import AnimalsP.Predator;
import IslandP.Location;

public class Wolf extends Predator {


    public Wolf(int x, int y) {
        super(0, 3, 50, 30, 8, 8, x, y);
    }

    @Override
    public void eat(Location location) {
        super.eat(location);
    }


}
