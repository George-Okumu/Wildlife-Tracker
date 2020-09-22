package models;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animal implements DatabaseManagement{
    private String animalGroupAge;
    private String animalCondition;

    public static final String DATABASE_TYPE = "endangeredAnimal";

    public EndangeredAnimal(String animalName, int animalId, int age, String animalCondition, String animalGroupAge) {
        this.animalName = animalName;
        this.animalId = animalId;
        this.age = age;
        this.animalCondition = animalCondition;
        this.animalGroupAge = animalGroupAge;
        type = DATABASE_TYPE;
    }




    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='endangeredAnimal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }



}
