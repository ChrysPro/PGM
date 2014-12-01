/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

/**
 *
 * @author nbrandt
 */
public class PGM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Read image = new Read("lena.pgm");
        image.lecture("lena.pgm");
        Histogramme histo = new Histogramme(image);
        for (int i=0;i<histo.getHisto().getLargeur()*histo.getHisto().getLongueur();i++) {
            System.out.println(histo.getHisto().getTableau().get(i));
        }
        
    }
}
