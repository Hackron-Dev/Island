import AnimalsP.Animal;
import IslandP.Island;
import IslandP.Location;
import PlantP.Plant;

import java.util.List;

public class Simulation {



    int counter = 0;

    public static void animalLifeCycle(Island island) {
        //System.out.println("________________");
        //System.out.println("animalLifeCycle");//////////////////////////////////////////////////

        Location[][] allCells = island.getCells();
        boolean isAnyAlive = true;
        if (isAnyAlive) {
            isAnyAlive = false;
            for (int i = 0; i < allCells.length; i++) {
                for (int j = 0; j < allCells[i].length; j++) {
                    Location location = allCells[i][j];
                    List<Animal> animalList = location.getAnimalList();
                    if (!animalList.isEmpty()) {
                        isAnyAlive = true;

                        for (Animal el : animalList) {
                            //System.out.println("el: " + el);

                            el.move(el.getSpeed(), island);
                            el.eat(location);
                            el.reproduce(location);
                            el.die(location);


                        }
                    }
                }
            }
        }

        //Show.showIsland(island);


    }


    public static void plantLifeCycle(Island island) {
        //System.out.println("plantLifeCycle");/////////////////////////////////////////////////////
        Location[][] allCells = island.getCells();
        boolean isAnyPlantAlive = true;
        if (isAnyPlantAlive) {
            isAnyPlantAlive = false;
            for (int i = 0; i < allCells.length; i++) {
                for (int j = 0; j < allCells[i].length; j++) {
                    Location location = allCells[i][j];
                    List<Plant> plantList = location.getPlantList();


                    location.addPlant(new Plant());


                }
            }
        }

        //Simulation.animalLifeCycle(island);


    }


}
