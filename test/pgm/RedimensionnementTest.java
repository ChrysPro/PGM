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

/**
 *
 * @author nbrandt
 */
public class RedimensionnementTest {
    
    public RedimensionnementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setHauteur method, of class Redimensionnement.
     */
    @Test
    public void testSetHauteur() {
        System.out.println("setHauteur");
        int newHauteur = 0;
        Redimensionnement instance = null;
        Read expResult = null;
        Read result = instance.setHauteur(newHauteur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parLigne method, of class Redimensionnement.
     */
    @Test
    public void testParLigne() {
        System.out.println("parLigne");
        Read image = null;
        int r = 0;
        int a = 0;
        int b = 0;
        int i = 0;
        ArrayList<Integer> newTableau = null;
        Redimensionnement instance = null;
        instance.parLigne(image, r, a, b, i, newTableau);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLargeur method, of class Redimensionnement.
     */
    @Test
    public void testSetLargeur() {
        System.out.println("setLargeur");
        int newLargeur = 0;
        Redimensionnement instance = null;
        Read expResult = null;
        Read result = instance.setLargeur(newLargeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parColonne method, of class Redimensionnement.
     */
    @Test
    public void testParColonne() {
        System.out.println("parColonne");
        Read image = null;
        int r = 0;
        int a = 0;
        int b = 0;
        int i = 0;
        ArrayList newTableau = null;
        Redimensionnement instance = null;
        instance.parColonne(image, r, a, b, i, newTableau);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}