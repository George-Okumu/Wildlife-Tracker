package models;

import org.sql2o.Connection;

import java.util.List;

public class NonEndangeredAnimal extends Animal implements DatabaseManagement {

    private String animalGroupAge;
    private String animalCondition;

    public static final String DATABASE_TYPE = "NonEndangeredAnimal";

    public NonEndangeredAnimal(String animalName, int animalId, int age, String animalGroupAge, String animalCondition) {
        this.animalName = animalName;
        this.animalId = animalId;
        this.age = age;
        this.animalGroupAge = animalGroupAge;
        this.animalCondition = animalCondition;
        type = DATABASE_TYPE;
    }

    public static List<NonEndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='NonEndangeredAnimal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NonEndangeredAnimal.class);
        }
    }

    public static NonEndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            NonEndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(NonEndangeredAnimal.class);
            return animal;
        }
    }
}
