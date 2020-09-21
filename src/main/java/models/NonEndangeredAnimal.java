package models;

public class NonEndangeredAnimal extends Animal implements DatabaseManagement {

    public static final String DATABASE_TYPE = "NonEndangeredAnimal";

    public NonEndangeredAnimal(String animalName, int animalId, int age) {
        this.animalName = animalName;
        this.animalId = animalId;
        this.age = age;
        type = DATABASE_TYPE;
    }
}
