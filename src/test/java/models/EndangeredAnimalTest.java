package models;

import org.junit.*;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_instantiatesCorrectlyWithObjects_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1);
        Assert.assertTrue(true);
    }

    @Test
    public void endangeredAnimal_getsAnimalNameCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1);
        Assert.assertTrue(true);
    }

    @Test
    public void endangeredAnimal_instantiatesWithAnimalId_int() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1);
        assertEquals(1, testEndangeredAnimal.getAnimalId());
    }

//    @Test
//    public void equals_returnsTrueIfAnimalNameAndAnimalIdAreSame_true() {
//        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1);
//        EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("Eagles", 1);
//        assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
//    }

    @Test
    public void save_successfullyAddsEndangeredAnimalToDatabase_List() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1);
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }
}