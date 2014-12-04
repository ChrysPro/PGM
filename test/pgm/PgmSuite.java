/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author nbrandt
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({pgm.PGMTest.class, pgm.WriteTest.class, pgm.HistogrammeTest.class, pgm.RedimensionnementTest.class, pgm.ReadTest.class})
public class PgmSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}