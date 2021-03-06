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
public class Redimensionnement {
    
    Read image;
    int b;
    double a;
    
    /**
     *
     * @param im : image à redimensionner
     */
    public Redimensionnement(Read im){
        image=im;
        a=0;
        b=0;
    }
    
    /**
     * fonction qui modifie la hauteur d'une image
     * 
     * @param newHauteur : nouvelle hauteur de l'image
     * @return : l'image redimensionnée
     */
    public Read setHauteur(int newHauteur){
        
        double r = (Math.floor(((double)newHauteur/(double)image.getLongueur())*1000)/1000);//Ratio de redimensionnement
        a=0;//1-reste à utiliser de l'image à redimensionner
        b=0;//ligne courante de l'image à redimensionner
        Read newImage = new Read ("redimLongueur");//image redimensionné
        ArrayList<Integer> newTableau = new ArrayList();//tableau de l'image redimensionnée
        
        for(int i=0;i<image.getLargeur()*newHauteur;i++){
            newTableau.add(0);
        }
        
        for(int i=0;i<newHauteur;i++){
            
            this.parLigne(image, r, i, newTableau);
        }
        
        newImage.setTableau(newTableau);
        newImage.setLargeur(image.getLargeur());
        newImage.setLongueur(newHauteur);
        
        return newImage;
    }
    
    /**
     * fonction qui rempli une à une les lignes de l'image redimensionnée
     * 
     * @param image : image à redimensionner
     * @param r : Ratio de redimensionnement
     * @param i : ligne du tableau de l'image redimensionnée dont on s'occupe
     * @param newTableau : tableau partiellement rempli de l'image redimensionnée
     */
    public void parLigne(Read image, double r, int i, ArrayList<Integer> newTableau){
        double c=0;//% de remplissage de la nouvelle ligne
        double d;
        
        while(c<1 && b<image.getLongueur() ){
            if(r-a<=1-c){
                d=r-a;
            }else{
                d=1-c;
            }
            
            for(int j=0; j<image.getLargeur();j++){
                int m = (int)(image.getTableau().get(j+b*image.getLargeur())*d+newTableau.get(j+i*image.getLargeur()));
                newTableau.set(j+i*image.getLargeur(), m);
               
            }
            
             c=c+d;
             a=a+d;
                
            if(a==r){
                a=0;
                b++;
            }

            
        }
    }
    
    /**
     * fonction qui modifie la largeur d'une image
     * 
     * @param newLargeur : nouvelle largeur de l'image
     * @return : l'image redimensionnée
     */
    public Read setLargeur(int newLargeur){
        

        double r = (Math.floor(((double)newLargeur/(double)image.getLargeur())*1000)/1000);//Ratio de redimensionnement
        a=0;//1-reste à utiliser de l'image à redimensionner
        b=0;//colonne courante de l'image à redimensionner
        Read newImage = new Read ("redimLargeur");//image redimensionné
        ArrayList<Integer> newTableau = new ArrayList();//tableau de l'image redimensionnée
        for(int i=0;i<image.getLongueur()*newLargeur;i++){
            newTableau.add(0);
        }
        
        for(int i=0;i<newLargeur;i++){
            
            this.parColonne(image, r, i, newTableau, newLargeur);

        }
        
        newImage.setTableau(newTableau);
        newImage.setLargeur(newLargeur);
        newImage.setLongueur(image.getLongueur());
        
        return newImage;
        
    }
    
    /**
     * fonction qui rempli une à une les colonnes de l'image redimensionnée
     * 
     * @param image : image à redimensionner
     * @param r : Ratio de redimensionnement
     * @param i : colonne du tableau de l'image redimensionnée dont on s'occupe
     * @param newTableau : tableau partiellement rempli de l'image redimensionnée
     * @param newLargeur : largeur de l'image redimensionnée
     */
    public void parColonne(Read image, double r, int i, ArrayList<Integer> newTableau, int newLargeur){
        double c = 0;//% de remplissage de la nouvelle ligne
        double d = 0;
  
        
        while(c<1){
           
            if(r-a<=1-c){
                d=r-a;
            }else{
                d=1-c;
            }
             
            
            for(int j=0; j<image.getLongueur();j++){
                int z = (int)(image.getTableau().get(j*image.getLargeur()+b)*d+newTableau.get(j*newLargeur+i));
                newTableau.set(j*newLargeur+i,z);
                
            }
            c=c+d;
            a=a+d;
            
            
            
            if(a==r){
                b++;
                a=0;
                
            }
            
        }

    }
    
    
}
