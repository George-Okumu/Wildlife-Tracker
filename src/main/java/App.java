import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class App {
    public static void main(String[] args){
        get("/", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newVulnerable", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "EndangeredAnimalForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sighting", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Sightings-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newNonExtinct", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Non-ExtinctForm.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
