import models.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){

        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o Animals = new Sql2o(connectionString, "moringa", "Georgedatabase1");
//        EndangeredAnimal endangeredAnimal = new EndangeredAnimal(StringanimalName, int animalId, );

        get("/", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newVulnerable", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "EndangeredAnimalForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangeredAnimal", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            int age = Integer.parseInt(request.queryParams("age"));
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String animalGroupAge = request.queryParams("animalGroupAge");
            String animalCondition = request.queryParams("animalCondition");
            EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(animalName, age, animalId, animalGroupAge, animalCondition);
            model.put("newEndangeredAnimal", newEndangeredAnimal);
            return new ModelAndView(model, "Success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/newNonExtinct", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Non-ExtinctForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/newNonExtinct", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            int age = Integer.parseInt(request.queryParams("age"));
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String animalGroupAge = request.queryParams("animalGroupAge");
            String animalCondition = request.queryParams("animalCondition");
            NonEndangeredAnimal newNonEndangeredAnimal = new NonEndangeredAnimal(animalName, age, animalId, animalGroupAge, animalCondition);
            model.put("newNonEndangeredAnimal", newNonEndangeredAnimal);
            return new ModelAndView(model, "Success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sighting", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Sightings-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/newSighting", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            Sighting newSighting = new Sighting(animalId, location, rangerName);
            model.put("newSighting", newSighting);
            return new ModelAndView(model, "Success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
