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

        for (int j = 0; j < image.getTableau().size(); j++) {
            
            detail.add(image.getTableau().get(j), detail.get(image.getTableau().get(j)) +  1);
        }
    }
    
    public void creerHistogramme(){
        creerDetail();
        int max=0;
        for(int i=0;i<256;i++){
            if(detail.get(i)>max){
                max=detail.get(i);
            }
        }
        histo.setNomfichier("histogramme");
        int largeur=256*2;
        int longueur=max;
        histo.setLargeur(largeur);
        histo.setLongueur(longueur);
        
        ArrayList<Integer> tableau = new ArrayList();
        for(int j=0;j<largeur;j++){
            for(int i=0;i<longueur;i++){
                if(detail.get(j)<longueur-i){
                    tableau.add(i*largeur+j, 0);
                }else{
                    tableau.add(i*largeur+j, 255);
                }
            }
        }
        
        histo.setTableau(tableau);
    }
}


