package models;

import org.junit.*;

import static org.junit.Assert.*;

public class NonEndangeredAnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void nonEndangeredAnimal_instantiatesCorrectlyWithObjects_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("mongoose",1, 3, "health", "young");
        Assert.assertTrue(true);
    }
    @Test
    public void nonEndangeredAnimal_getsAnimalNameCorrectly_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        assertEquals("Mongoose",testNonEndangeredAnimal.getAnimalName());
    }

    @Test
    public void nonEndangeredAnimal_getsAnimalAgeCorrectly_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        assertEquals(3, testNonEndangeredAnimal.getAge());
    }

    @Test
    public void NonEndangeredAnimal_instantiatesWithAnimalId_int() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        assertEquals(1, testNonEndangeredAnimal.getAnimalId());
    }
    @Test
    public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        NonEndangeredAnimal anotherNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        assertTrue(testNonEndangeredAnimal.equals(anotherNonEndangeredAnimal));
    }

    @Test
    public void save_successfullyAddsNonEndangeredAnimalToDatabase_List() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        testNonEndangeredAnimal.save();
        assertTrue(NonEndangeredAnimal.all().get(0).equals(testNonEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToNonEndangeredAnimal() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        testNonEndangeredAnimal.save();
        NonEndangeredAnimal savedNonEndangeredAnimal = NonEndangeredAnimal.all().get(0);
        assertEquals(savedNonEndangeredAnimal.getId(), testNonEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfNonEndangeredAnimal_true() {
        NonEndangeredAnimal firstNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        firstNonEndangeredAnimal.save();
        NonEndangeredAnimal secondNonEndangeredAnimal = new NonEndangeredAnimal("Plain Zebra", 3, 5, "health", "young");
        secondNonEndangeredAnimal.save();
        assertEquals(true, NonEndangeredAnimal.all().get(0).equals(firstNonEndangeredAnimal));
        assertEquals(true, NonEndangeredAnimal.all().get(1).equals(secondNonEndangeredAnimal));
    }

    @Test
    public void find_returnsNonEndangeredAnimalWithSameId_secondNonEndangeredAnimal() {
        NonEndangeredAnimal firstNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3, "health", "young");
        firstNonEndangeredAnimal.save();
        NonEndangeredAnimal secondNonEndangeredAnimal = new NonEndangeredAnimal("Plain Zebra", 1, 4, "health", "young");
        secondNonEndangeredAnimal.save();
        assertEquals(NonEndangeredAnimal.find(secondNonEndangeredAnimal.getId()), secondNonEndangeredAnimal);
    }


}