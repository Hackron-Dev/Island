import AnimalsP.Animal;
import IslandP.Island;
import IslandP.Location;
import PlantP.Plant;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Show {
    private static final Logger logger = Logger.getLogger(Show.class.getName());
    public static void showIsland(Island island) {
       // System.out.println("showIsland"); ////////////////////////////////////////////////////
        Location[][] allCells = island.getCells();
        int animalCounter = 0;
        int plantCounter = 0;

            for (int i = 0; i < allCells.length; i++) {
                for (int j = 0; j < allCells[i].length; j++) {
                    Location location = allCells[i][j];
                    List<Plant> plantList = location.getPlantList();
                    List<Animal> animalList = location.getAnimalList();

                    System.out.print("P:"+plantList.size() + " A:"+animalList.size() + "| ");
                    animalCounter += animalList.size();
                    plantCounter += plantList.size();


                }
                System.out.println();
            }
            logger.info("ANIMALS: " + animalCounter);
            logger.info("PLANTS: " + plantCounter);
            if ( animalCounter <= 1) {
                logger.severe("NO MORE ANIMALS :( !");
                System.exit(666);
            }


            //Simulation.plantLifeCycle(island);
        }
    }

