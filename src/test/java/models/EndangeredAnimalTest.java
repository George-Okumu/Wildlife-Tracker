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
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1, 4);
        Assert.assertTrue(true);
    }

    @Test
    public void endangeredAnimal_getsAnimalNameCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1, 4);
        assertEquals("Eagle",testEndangeredAnimal.getAnimalName());
    }

    @Test
    public void endangeredAnimal_getsAnimalAgeCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1, 4);
        assertEquals(4, testEndangeredAnimal.getAge());
    }

    @Test
    public void endangeredAnimal_instantiatesWithAnimalId_int() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1, 4);
        assertEquals(1, testEndangeredAnimal.getAnimalId());
    }

    @Test
    public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Bubbles", 1, 4);
        EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("Bubbles", 1, 4);
        assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
    }

    @Test
    public void save_successfullyAddsEndangeredAnimalToDatabase_List() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1, 4);
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", 1, 4);
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Eagle", 1, 4);
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Lion", 3, 5);
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }

    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Eagle", 1, 4);
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Lion", 1, 4);
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }
}