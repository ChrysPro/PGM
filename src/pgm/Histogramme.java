

package pgm;

import java.util.ArrayList;

/**
 *
 * @author ybellehi
 */
public class Histogramme {

    private Read image;
    private Read histo = new Read("");
    private ArrayList<Integer> detail= new ArrayList();

    /**
     *création d'un histogramme à partir d'une image
     * @param i : pour l'image dont on cherche l'histogramme
     */
    public Histogramme(Read i) {
       image = i;
       this.creerHistogramme();
        }

    /**
     * renvoie l'histogramme
     * @return 
     */
    
    public Read getHisto() {
        return histo;
    }
    
    

    /**
     *création d'un tableau regroupant le nombre d'apparition de chaque valeur de niveaux de gris
     */
    public void creerDetail() {

  
        for (int i = 0; i < 256; i++) {
            detail.add(i, 0);
        }
System.out.println(image.getTableau().size());
        for (int j = 0; j < image.getTableau().size() ; j++) {
            
            detail.set(image.getTableau().get(j), detail.get(image.getTableau().get(j)) +  1);
            //System.out.println(j);
        }

    
    }
    
    /**
     * création d'histogramme au format image
     */
    public void creerHistogramme(){
        this.creerDetail();
        int max=0;
        for(int i=0;i<256;i++){
            if(detail.get(i)>max){
                max=detail.get(i);
            }
        }
        System.out.println("max : " + max);
        histo.setNomfichier("histogramme");
        int largeur=256;
        int longueur=max;
        histo.setLargeur(largeur);
        histo.setLongueur(longueur);
        
        ArrayList<Integer> tableau = new ArrayList();
        for(int k=0;k<longueur*largeur;k++){
            tableau.add(k,255);
        }
        for(int j=0;j<largeur;j++){
            for(int i=0;i<longueur;i++){
                if(detail.get(j)>longueur-i){
                    tableau.set(i*largeur+j, 0);
                }
            }
        }
        histo.setTableau(tableau);
    }
}


