/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author nbrandt
 */
public class ReadTest {
    
    public ReadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of creerObjet method, of class Read.
     */
    @Test
    public void testCreerObjet() {
        System.out.println("creerObjet");
        Read instance = new Read("test");
        assertEquals(0, instance.creerObjet("34",0));
        assertEquals(1, instance.creerObjet("# hello world",0));
        assertEquals(2, instance.creerObjet("45 21",1));
        assertEquals(0, instance.creerObjet("45 21",0));
    }
    
/**
 * Exceptions
 */
    @Test(expected = IllegalArgumentException.class)
    public void checkExpectedException() {
        System.out.println("checkExpectedException");
        Read instance = new Read("test");
        System.out.println(instance.creerObjet("Hello World",0));
        System.out.println(instance.creerObjet("Hello World",1));
        System.out.println(instance.creerObjet("Hello World",2));
    }
    /**
     * Test of lecture method, of class Read.
     */
    
    @Test
    public void testLecture() {
        System.out.println("lecture");
        Read instance = new Read("lecture.pgm");
        assertEquals("P2#1 125565", instance.lecture());
       
    }
}