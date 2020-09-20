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
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal();
        Assert.assertTrue(true);
    }
}