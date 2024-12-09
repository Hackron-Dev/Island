package AnimalsP;
import IslandP.Location;

import java.util.List;

public abstract class Predator extends Animal{


    public Predator(int id, int speed, double weight, int maxOnCell, int energy, int maxEnergy, int x, int y) {
        super(id, speed, weight, maxOnCell, energy, maxEnergy, x, y);
    }


    public void eat(Location location) {
        List<Animal> animalList = location.getAnimalList();
        int chance = random.nextInt(101);
        if (energy != 0 && energy < maxEnergy / 100 * 65) {
            for (Animal el : animalList) {
                  if (chance <= probabilityMatrix[this.id][el.id] && probabilityMatrix[this.id][el.id] > 0) {
                    //System.out.println("Predator: " + this.id + " ate " + el.id);
                    location.removeAnimal(el);
                    energy += weight / 10;
                    if (energy > maxEnergy) {
                        energy = maxEnergy;
                    }
                }
            }

        }
    }



}
