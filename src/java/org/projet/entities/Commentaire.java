
package org.projet.entities;

import java.util.Date;
import java.util.List;


public class Commentaire {
    
    private String id_com;
    private String id_offre;
    private String id_ensiaste;
    private String comment;
    private String nom;
    private String prenom;
    private Date datePub;

    public String getId_com() {
        return id_com;
    }

    public String getId_offre() {
        return id_offre;
    }

    public String getId_ensiaste() {
        return id_ensiaste;
    }

    
    
    
    public void setId_com(String id_com) {
        this.id_com = id_com;
    }

    public void setId_offre(String id_offre) {
        this.id_offre = id_offre;
    }

    public void setId_ensiaste(String id_ensiaste) {
        this.id_ensiaste = id_ensiaste;
    }
    
    
    
    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    
    
    public String getComment() {
        return comment;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDatePub() {
        return datePub;
    }
    
    
}
