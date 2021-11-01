
package org.projet.entities;

public class Administrateur extends Compte{
    private int id_ad;
    private String nom;
    private String  prenom;
    private String cne;

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }
    
    
    public int getId_ad() {
        return id_ad;
    }

     public void setId_ad(int id_ad) {
        this.id_ad = id_ad;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   
}
