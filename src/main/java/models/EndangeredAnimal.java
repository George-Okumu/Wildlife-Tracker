package models;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animal implements DatabaseManagement{

    public static final String DATABASE_TYPE = "endangeredAnimal";

    public EndangeredAnimal(String animalName, int animalId) {
        this.animalName = animalName;
        this.animalId = animalId;
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




}
