package models;

import org.sql2o.Connection;

public abstract class Animal {
    public String animalName;
    public int animalId;
    public String type;// type of animal either endangered or non-endangered.
    public int id;

    public String getAnimalName() {
        return animalName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getId() {
        return id;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName, animalId, type) VALUES (:animalName, :animalId, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", this.animalName)
                    .addParameter("animalId", this.animalId)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getAnimalName().equals(newAnimal.getAnimalName()) &&
                    this.getAnimalId() == newAnimal.getAnimalId();
        }
    }

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

}
