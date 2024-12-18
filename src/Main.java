import IslandP.Island;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int width = 20; // Ширина острова // x
        int height = 20; // Высота острова // y
        int animalCount = 200; // Количество животных
        int plantCount = 800;  // Количество растений


        // Создаем остров
        logger.info("Creating Island!");
        Island island = new Island(width, height);

        // Заселяем остров животными и растениями
        logger.info("Populating Island!");
        island.populateIsland(animalCount, plantCount, width, height);

        // Количество потоков
        int threadCount = 3;


        CountDownLatch latch = new CountDownLatch(threadCount);

        // Количество циклов
        int cycles = 100;

        for (int i = 0; i < cycles; i++) {
            logger.info("Cycle " + (i + 1));


            CountDownLatch finalLatch = latch;
            Thread plantLifeCycleThread = new Thread(() -> {
                try {
                    Simulation.plantLifeCycle(island);
                } finally {
                    finalLatch.countDown();
                }
            });

            CountDownLatch finalLatch1 = latch;
            Thread animalLifeCycleThread = new Thread(() -> {
                try {
                    Simulation.animalLifeCycle(island);
                } finally {
                    finalLatch1.countDown();
                }
            });

            CountDownLatch finalLatch2 = latch;
            Thread showIslandThread = new Thread(() -> {
                try {
                    Show.showIsland(island);
                } finally {
                    finalLatch2.countDown();
                }
            });


            plantLifeCycleThread.start();
            animalLifeCycleThread.start();
            showIslandThread.start();

            try {

                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.severe("Simulation interrupted: " + e.getMessage());
            }


            latch = new CountDownLatch(threadCount);

            try {
                // Задержка 1 сек
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.severe("Sleep interrupted: " + e.getMessage());
            }
        }

        logger.info("Simulation finished after " + cycles + " cycles.");
    }
}
