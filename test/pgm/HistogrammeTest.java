/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nbrandt
 */
public class HistogrammeTest {
    
    public HistogrammeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getHisto method, of class Histogramme.
     */
    @Test
    public void testGetHisto() {
        System.out.println("getHisto");
        Histogramme instance = null;
        Read expResult = null;
        Read result = instance.getHisto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerDetail method, of class Histogramme.
     */
    @Test
    public void testCreerDetail() {
        System.out.println("creerDetail");
        Histogramme instance = null;
        instance.creerDetail();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerHistogramme method, of class Histogramme.
     */
    @Test
    public void testCreerHistogramme() {
        System.out.println("creerHistogramme");
        Histogramme instance = null;
        instance.creerHistogramme();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}