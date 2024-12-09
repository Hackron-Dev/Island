package IslandP;

import AnimalsP.Animal;
import AnimalsP.HerbivoresP.Caterpillar;
import PlantP.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Location {
    private final List<Animal> animalList; //Создание листа животны
    private final List<Plant> plantList;  //Создание листа растений

    public Location() {
        this.animalList = new ArrayList<>();
        this.plantList = new ArrayList<>();
    }

    public List<Animal> getAnimalList() {
        return new ArrayList<>(animalList);
    }

    public List<Integer> getAnimalIdList() {
        return animalList.stream()
                     .map(Animal::getId)
                     .collect(Collectors.toList()).reversed();
    }



    public List<Plant> getPlantList() {
        return new ArrayList<>(plantList);
    }


    public void addAnimal(Animal animal) {
        this.animalList.add(animal);


    }

    public void removeAnimal(Animal animal) {
        animalList.remove(animal);
    }

    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    public void removePlant(Plant plant) {
        plantList.remove(plant);
    }





}
