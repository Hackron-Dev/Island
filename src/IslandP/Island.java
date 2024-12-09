package IslandP;

import AnimalsP.HerbivoresP.*;
import AnimalsP.PredatorsP.*;
import PlantP.Plant;

import java.util.Random;

public class Island {
    private final Location[][] cell; // Location - тип объектов, Cell - название массива с объектами Location
    Random random = new Random();

    public Island(int Width, int Height) {

        // В каждую из клеток добавить объект содержащий хранилище животных и растений для дальнейших манипуляций
        cell = new Location[Width][Height];
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[i].length; j++)  {
                cell[i][j] = new Location();
            }
        }

    }

    public void populateIsland(int animalCount, int plantCount, int Width, int Height) { //Добавить проверку на переполнение
        for (int i = 0; i < animalCount; i++) {
            int x = random.nextInt(Width);
            int y = random.nextInt(Height);
            switch (random.nextInt(15)) {
                case 0:
                    cell[x][y].addAnimal(new Wolf(x, y));
                case 1:
                    cell[x][y].addAnimal(new Snake(x, y));
                case 2:
                    cell[x][y].addAnimal(new Fox(x, y));
                case 3:
                    cell[x][y].addAnimal(new Bear(x, y));
                case 4:
                    cell[x][y].addAnimal(new Eagle(x, y));
                case 5:
                    cell[x][y].addAnimal(new Horse(x, y));
                case 6:
                    cell[x][y].addAnimal(new Deer(x, y));
                case 7:
                    cell[x][y].addAnimal(new Rabbit(x, y));
                case 8:
                    cell[x][y].addAnimal(new Mouse(x, y));
                case 9:
                    cell[x][y].addAnimal(new Goat(x, y));
                case 10:
                    cell[x][y].addAnimal(new Sheep(x, y));
                case 11:
                    cell[x][y].addAnimal(new Boar(x, y));
                case 12:
                    cell[x][y].addAnimal(new Buffalo(x, y));
                case 13:
                    cell[x][y].addAnimal(new Duck(x, y));
                case 14:
                    cell[x][y].addAnimal(new Caterpillar(x, y));
            }
        }
        for (int i = 0; i < plantCount; i++) {
            int x = random.nextInt(Width);
            int y = random.nextInt(Height);
            cell[x][y].addPlant(new Plant());
        }

        //System.out.println(cell[0][0].getAnimalIdList());
//
        //System.out.println("pupulated!");
    }

    public Location getLocation(int x, int y) {
        return cell[x][y];
    }

    public Location[][] getCells() {
        return cell;
    }
}