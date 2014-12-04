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
        Write ecrImage = new Write(image, "test1.pgm");
        Write ecrHisto = new Write(histo.getHisto(), "test2.pgm");
        /*for (int i=0;i<histo.getHisto().getLargeur()*histo.getHisto().getLongueur();i++){
         System.out.println(histo.getHisto().getTableau().get(i));
         }*/


        Redimensionnement Bob = new Redimensionnement(histo.getHisto());

        Read image1 = Bob.setLargeur(2048);

        //Redimensionnement Bob2 = new Redimensionnement(image);
        //Read image2 = Bob2.setHauteur(615);
        Write ecrBob = new Write(image1, "bob.pgm");
        //Write ecrBob2 = new Write(image2, "bob2.pgm");
    }
}
