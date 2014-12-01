/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import java.util.ArrayList;

/**
 *
 * @author ybellehi
 */
public class Histogramme {

    private Read image;
    private Read histo;
    private ArrayList<Integer> detail;

    public Histogramme(Read i) {
        image = i;
    }

    public void creerDetail() {

        for (int i = 0; i < 256; i++) {
            detail.add(i, 0);
        }

        for (int j = 0; j < image.getTableau().size(); j++) { //TODO jusqu'à la derniere valeur de l'ArrayList
            
            detail.add(image.getTableau().get(j), detail.get(image.getTableau().get(j)) +  1);//TODO remplacer ArrayList par la fonction necessaire
        }
    }
    
    public void creerHistogramme(){
        creerDetail();
        //TODO écrire le PGM de l'histogramme
    }
}


