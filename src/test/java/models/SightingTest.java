package models;

import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class SightingTest {
   // private static  Connection conn;

//    @BeforeClass
//    public static void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
//        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Georgedatabase1");
//        conn = sql2o.open(); //keep connection open through entire test so it does not get erased
//    }
//    @After
//    public void tearDown() throws Exception {
//        System.out.println("database disconnecting");
//        Sighting.clearAllSightings();
//    }
//    @AfterClass
//    public static void logOut(){
//        System.out.println("Beaming out... bye!");
//        conn.close();
//    }
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true() {
        Sighting testSighting = new Sighting(1, "George", "Zone B");
        Assert.assertTrue(true);
    }

    @Test
    public void sighting_instantiatesWithAnimalId_true() {
        Sighting testSighting = new Sighting(1, "George", "Zone A");
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    public void sighting_instantiatesCorrectlyWithLocation() {
        Sighting testSighting = new Sighting(1, "George", "Zone C");
        assertEquals("Zone C", testSighting.getLocation());
    }

    @Test
    public void sighting_instantiatesCorrectlyWithRangerName_rangerName() {
        Sighting testSighting = new Sighting(1, "George", "Zone C");
        assertEquals("George", testSighting.getRangerName());
    }

    @Test
    public void equals_returnsTrueIfAnimalIdRangerNameAndLocationAreTheSame_true() {
        Sighting firstPerson = new Sighting(1, "George", "Zone A");
        Sighting secondPerson = new Sighting(1, "George", "Zone A");
        assertEquals(true, firstPerson.equals(secondPerson));
    }

    @Test
    public void save_insertsObjectIntoDatabase_() {
        Sighting testSighting = new Sighting(1, "George", "Zone B");
        testSighting.save();
        assertTrue(Sighting.all().get(0).equals(testSighting));
    }


    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sighting firstSighting = new Sighting(1, "George", "Zone A");
        firstSighting.save();
        Sighting secondSighting = new Sighting(1, "Vivian", "Zone B");
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }

}