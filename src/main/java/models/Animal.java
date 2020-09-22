package models;

import org.sql2o.Connection;

import java.util.Objects;

public abstract class Animal {
    public String animalName;
    public int animalId;
    public int age;
    public String type;// type of animal either endangered or non-endangered.
    public int id;


    public String getAnimalName() {
        return animalName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getAge() {
        return age;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId &&
                animalName.equals(animal.animalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, animalId);
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
