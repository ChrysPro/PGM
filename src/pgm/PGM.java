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
        Read image = new Read("lecture.pgm");
        image.lecture();
        image.setCommentaire("Hello");
        System.out.println(image.getCommentaire());
        image.setCommentaire("# Hello");
        System.out.println(image.getCommentaire());
        Histogramme histo = new Histogramme(image);
        System.out.println(histo.getHisto().getLargeur() + " " + histo.getHisto().getLongueur());
        for(int i=0;i<(histo.getHisto().getLargeur())*(histo.getHisto().getLongueur());i++) {
            System.out.println(histo.getHisto().getTableau().get(i));
        }
        Write chose= new Write(image, "lena2.pgm");
        
    }
}
