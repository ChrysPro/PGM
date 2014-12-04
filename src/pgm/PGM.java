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
        Read image = new Read("\\\\data-pfe\\ybellehi\\NetBeansProjects\\PGM\\src\\resources\\lena.pgm");
        image.lecture();
        Histogramme histo = new Histogramme(image);
        System.out.println(histo.getHisto().getLargeur() + " " + histo.getHisto().getLongueur());
        for(int i=0;i<(histo.getHisto().getLargeur())*(histo.getHisto().getLongueur());i++) {
            System.out.println(histo.getHisto().getTableau().get(i));
        }
        
    }
}
