package AnimalsP;


import AnimalsP.PredatorsP.Wolf;
import IslandP.Island;
import IslandP.Location;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public abstract class Animal {
    protected int id;
    protected int speed;
    protected double weight;
    protected int maxOnCell;
    protected double energy;
    protected double maxEnergy;
    protected int x;
    protected int y;
    protected static int[][] probabilityMatrix = {
            {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}
    };
    Random random = new Random();

    public Animal(int id, int speed, double weight, int maxOnCell, double energy, double maxEnergy, int x, int y) {
        this.id = id;
        this.weight = weight;
        this.maxOnCell = maxOnCell;
        this.speed = speed;
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.x = x;
        this.y = y;
    }


    abstract public void eat(Location location);


    public void move(int speed, Island island) {
        Location[][] allCells = island.getCells();

        // 1 Рандом - это выбор направления (0 назад(y-1) , 1 вперед (y+1) , 2 лево (x-1) , 3 право (x+1))
        int number = random.nextInt(4); // генерирует число от 0 до 3
        int dest = this.speed;
        int old_x = x;
        int old_y = y;

        int max_y = allCells.length;
        int max_x = allCells[1].length;
        //System.out.println(allCells);
        //System.out.println("dest: " + dest);
        switch (number) {
            case 0:
                if (y - dest >= 0) {
                    this.y -= dest;
                    this.energy -= ((dest + maxEnergy) * 0.10) * 0.25;
                }
                break;
            case 1:
                if (y + dest < max_y) {
                    this.y += dest;
                    this.energy -= ((dest + maxEnergy) * 0.10) * 0.25;
                }
                break;
            case 2:
                if (x - dest >= 0) {
                    this.x -= dest;
                    this.energy -= ((dest + maxEnergy) * 0.10) * 0.25;
                }
                break;
            case 3:
                if (x + dest < max_x) {
                    this.x += dest;
                    this.energy -= ((dest + maxEnergy) * 0.10) * 0.25;
                }
                break;

        }

        Location currentLocation = island.getLocation(old_x, old_y);
        Location newLocation = island.getLocation(x, y);
        currentLocation.removeAnimal(this);
        newLocation.addAnimal(this);


        if (this.energy < 1) {
            newLocation.removeAnimal(this);

        } else {
            if (old_x == x && old_y == y) {
                //System.out.println("Same position " + this);
            } else {
                //System.out.println("old x:" + old_x + " old y:" + old_y + " new x: " + x + " new y: " + y + "mob: " + this + " energy: " + this.energy);
            }

        }


    }


    public void reproduce(Location location) {
        //System.out.println("try ebatca");

        List<Integer> animalListID = location.getAnimalIdList();
        List<Animal> animalList = location.getAnimalList();

        int count = Collections.frequency(animalListID, this.id); //43
        if (count >= 2 && count <= this.maxOnCell) {
            for (int i = 0; i < count; i++) {
                location.addAnimal(this);
            }
        }



    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }


    public void die(Location location) {
        if (energy < 1) {
            location.removeAnimal(this);
        }
    }

    public int getSpeed() {
        return this.speed;
    }


}
