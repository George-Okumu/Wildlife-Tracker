package models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonEndangeredAnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void nonEndangeredAnimal_instantiatesCorrectlyWithObjects_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("mongoose",1, 3);
        Assert.assertTrue(true);
    }
    @Test
    public void nonEndangeredAnimal_getsAnimalNameCorrectly_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3);
        assertEquals("Mongoose",testNonEndangeredAnimal.getAnimalName());
    }

    @Test
    public void nonEndangeredAnimal_getsAnimalAgeCorrectly_true() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", 1, 3);
        assertEquals(3, testNonEndangeredAnimal.getAge());
    }

    @Test
    public void NonEndangeredAnimal_instantiatesWithAnimalId_int() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Eagle", 1, 3);
        assertEquals(1, testNonEndangeredAnimal.getAnimalId());
    }
}