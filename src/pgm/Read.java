/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import java.io.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nbrandt
 */
public class Read {
    
    /**
     * Le nom du fichier pgm à lire
     */
    public String filename;
    /**
     * longueur (hauteur) de l'image
     */
    public int hauteur;
    /**
     * largeur de l'image
     */
    public int largeur;
    /**
     * tableau des valeurs de niveaux de gris
     */
    public ArrayList<Integer> tableau;
    /*
     * Commentaire de l'image
     */
    String commentaire;

    /**
     * Le constructeur 
     * @param filename
     */
    public Read(String filename) {
        this.filename = filename;
        this.largeur=0;
        this.hauteur=0;
        this.tableau= new ArrayList();
    }

    /**
     * 
     * @param nomfichier
     */
    public void setNomfichier(String nomfichier) {
        this.filename= nomfichier;
    }

    /**
     *
     * @param longueur
     */
    public void setLongueur(int longueur) {
        this.hauteur = longueur;
    }

    /**
     *
     * @param largeur
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     *
     * @param tableau
     */
    public void setTableau(ArrayList<Integer> tableau) {
        this.tableau = tableau;
    }

    /**
     *
     * @return
     */
    public String getNomfichier() {
        return filename;
    }

    /**
     *
     * @return
     */
    public int getLongueur() {
        return hauteur;
    }

    /**
     *
     * @return
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * renvoie le tableau défini ci dessus
     * @return
     */
    public ArrayList<Integer> getTableau() {
        return tableau;
    }
    
   
 
    
    /**
     *Lit une ligne du fichier pgm et rempli l'Arraylist en fonction
     * ainsi que les dimensions dans des attributs séparés
     * @param ligne
     * @param buffer
     */
    public int creerObjet (String ligne, int test) {
            String delimiters = " .,;	";
            String mot;
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiters);
            mot = tokenizer.nextToken();
            switch (mot) {
                case "P2":
                    break;
                //La ligne commençant par # annonce que la prochaine ligne concernera les dimensions de l'image
                case "#":
                 // On a repéré la ligne de commentaire
                    this.commentaire=ligne;
                // la variable test permet de considerer de maniere particulière les 2 lignes après le dièse.
                        test=1;                
                    break;
                default:
                    if (test==1) {
                     this.largeur=Integer.parseInt(mot);
                     mot= tokenizer.nextToken();
                     this.hauteur=Integer.parseInt(mot);
                     System.out.println(mot);
                     test=2;
                     break;
                    } else if (test==2) {
                        test = 0;
                        break;
                    }
                    else {
                    this.tableau.add(Integer.parseInt(mot));
                    while (tokenizer.hasMoreTokens()) {
                        mot = tokenizer.nextToken();
                        this.tableau.add(Integer.parseInt(mot));
                    }
                    
                    
                    break;}
            }
        return test;
    }
    
    /**
     *Fonction qui permet de lire intégralement le fichier pgm et de l'insérer dans les attributs de la classe Read
     */
    public void lecture() {
        //Read lect=new Read(filename);
        try {
            String ligne;
            String mot;
            int test=0;
            BufferedReader buffer = new BufferedReader(new FileReader(filename));
             while ((ligne = buffer.readLine()) !=null){
                //System.out.println(ligne);
               test=this.creerObjet(ligne, test);
                }
             }
        catch (Exception e) {
            e.printStackTrace();
}
   System.out.println(this.tableau.size());}
}
    

