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
    public String nomfichier;
    /**
     * longueur (hauteur) de l'image
     */
    public int longueur;
    /**
     * largeur de l'image
     */
    public int largeur;
    /**
     * tableau des valeurs de niveaux de gris
     */
    public ArrayList<Integer> tableau;

    /**
     * Le constructeur 
     * @param nomfichier
     */
    public Read(String nomfichier) {
        this.nomfichier = nomfichier;
        this.largeur=0;
        this.longueur=0;
        this.tableau= new ArrayList();
    }

    /**
     * 
     * @param nomfichier
     */
    public void setNomfichier(String nomfichier) {
        this.nomfichier = nomfichier;
    }

    /**
     *
     * @param longueur
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
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
        return nomfichier;
    }

    /**
     *
     * @return
     */
    public int getLongueur() {
        return longueur;
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
     * @param lect
     * @param buffer
     */
    public void creerObjet (String ligne, Read lect, BufferedReader buffer) {
        try {
            String delimiters =" ";
            String mot;
            StringTokenizer tokenizer=new StringTokenizer(ligne, delimiters);
            mot=tokenizer.nextToken();
                switch (mot.toLowerCase()) {
                    case "P2" : 
                        break;
                  //La ligne commençant par # annonce que la prochaine ligne concernera les dimensions de l'image
                    case "#" :
                        if ((ligne = buffer.readLine()) !=null) {
                            tokenizer= new StringTokenizer (ligne, delimiters);
                            mot=tokenizer.nextToken();
                            lect.largeur=Integer.parseInt(mot);
                            mot=tokenizer.nextToken();
                            lect.longueur=Integer.parseInt(mot); 
                  // On saute la ligne précisant la valeur max du niveau de gris (toujours 255)
                            ligne=buffer.readLine();
                        }
                        break;
                   default :
                       lect.tableau.add(Integer.parseInt(mot));
                       while (tokenizer.hasMoreTokens())
                           mot=tokenizer.nextToken();
                       lect.tableau.add(Integer.parseInt(mot));
                           break;
            }
        } catch (IOException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *Fonction qui permet de lire intégralement le fichier pgm et de l'insérer dans les attributs de la classe Read
     * @param filename
     * @return
     */
    public Read lecture(String filename) {
        Read lect=new Read(filename);
        try {
            String ligne;
            String mot;
            BufferedReader buffer = new BufferedReader(new FileReader(nomfichier));
             while ((ligne = buffer.readLine()) !=null){
               creerObjet(ligne, lect , buffer);
                }
             }
        catch (Exception e) {
}
return lect;}
}
    

