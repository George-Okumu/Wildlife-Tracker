package models;

public class EndangeredAnimal extends Animal implements DatabaseManagement{

    public EndangeredAnimal(String animalName, int animalId) {
        this.animalName = animalName;
        this.animalId = animalId;
    }
}
