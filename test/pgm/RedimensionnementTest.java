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
    @Ignore
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
        Read image = new Read("image");
        image.setLargeur(10);
        image.setLongueur(1);
        ArrayList tableau = new ArrayList();
        for(int j=0;j<10;j++){
            tableau.add(j);
        }
        image.setTableau(tableau);
        double r = 2;
        int i = 0;
        ArrayList newTableau = new ArrayList();
        for(int j=0;j<20;j++){
             newTableau.add(0);      
        }
        Redimensionnement instance = new Redimensionnement(image);
        instance.parLigne(image, r, i, newTableau);
        
        ArrayList resultat = new ArrayList();
        for(int j=0;j<20;j++){
            resultat.add(0);
        }
        for(int j=0;j<10;j++){
            resultat.set(j,j);       
            resultat.set(j+10,0);
        }
        
        assertEquals(resultat, newTableau);
    }

    /**
     * Test of setLargeur method, of class Redimensionnement.
     */
    @Ignore
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
        Read image = new Read("image");
        image.setLargeur(1);
        image.setLongueur(10);
        ArrayList tableau = new ArrayList();
        for(int j=0;j<10;j++){
            tableau.add(j);
        }
        image.setTableau(tableau);
        int newLargeur = 2;
        double r = 2;
        int i = 0;
        ArrayList newTableau = new ArrayList();
        for(int j=0;j<9;j++){
            for(int k=0;k<2;k++){
                newTableau.add(0);      
            }
        }
        Redimensionnement instance = new Redimensionnement(image);
        instance.parColonne(image, r, i, newTableau, newLargeur);
        
        ArrayList resultat = new ArrayList();
        for(int j=0;j<18;j++){
            resultat.add(0);
        }
        for(int j=0;j<9;j++){
            resultat.set(j*2,j);       
            resultat.set(j*2+1,0);
        }
        
        assertEquals(resultat, newTableau);
    }
}