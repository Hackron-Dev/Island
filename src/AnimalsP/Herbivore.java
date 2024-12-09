package AnimalsP;

import IslandP.Island;
import IslandP.Location;
import PlantP.Plant;

import java.util.List;
import java.util.Random;

public abstract class Herbivore extends Animal{
    Random random = new Random();

    public Herbivore(int id, int speed, double weight, int maxOnCell, double energy, double maxEnergy, int x, int y) {
        super(id, speed, weight, maxOnCell, energy, maxEnergy, x, y);
    }




    public void eat(Location location) {
        List<Animal> animalList = location.getAnimalList();
        List<Plant> plantList = location.getPlantList();
        int chance = random.nextInt(101);
        if (energy > 0 && energy < maxEnergy / 100 * 65) {
            for (Animal el : animalList) {
                if (chance <= probabilityMatrix[this.id][el.id] && probabilityMatrix[this.id][el.id] > 0) {
                    //System.out.println("Herbivore: " + this.id + " ate " + el.id);
                    this.energy += el.weight / 10;
                    location.removeAnimal(el);
                    if (this.energy > this.maxEnergy) {
                        this.energy = this.maxEnergy;
                    }
                }
            }
            for (Plant el : plantList) {
                //System.out.println("Herbivore ate flower!");
                energy += 1;

                location.removePlant(el);
                if (this.energy > this.maxEnergy) {
                    this.energy = this.maxEnergy;
                    break;
                }
            }


        }
    }





}
