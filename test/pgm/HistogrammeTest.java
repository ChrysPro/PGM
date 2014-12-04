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
    @Ignore
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
        Read read = new Read("zero");
        read.setLongueur(256);
        read.setLargeur(256);

        ArrayList<Integer> listeRead = new ArrayList();
        ArrayList<Integer> tableau = new ArrayList();
        
        for(int i=0;i<256*256;i++){
            listeRead.add(i%256);
        }
        for(int i=0;i<256;i++){
            tableau.add(256);
        }
        
        read.setTableau(listeRead);
        Histogramme readH= new Histogramme(read);
        
        assertEquals(tableau, readH.getDetail());
    }

    /**
     * Test of creerHistogramme method, of class Histogramme.
     */

    @Test
    public void testCreerHistogramme() {
        System.out.println("creerHistogramme");
        Read read = new Read("zero");
        read.setLongueur(256);
        read.setLargeur(256);
        
        Read noir = new Read("noir");
        noir.setLongueur(256);
        noir.setLargeur(256);
        
        ArrayList<Integer> listeNoir = new ArrayList();
        ArrayList<Integer> listeRead = new ArrayList();

        
        for(int i=0;i<256*256;i++){
            listeRead.add(i%256);
            listeNoir.add(255);
        }
        
        read.setTableau(listeRead);
        noir.setTableau(listeNoir);

        
        Histogramme readH= new Histogramme(read);
        
        assertEquals(noir.getTableau(), readH.getHisto().getTableau());
    }
}