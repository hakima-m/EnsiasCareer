
package org.projet.entities;

import java.util.Date;

public class Offre {
   private String id_recuteur;
   private String contact;
   private String titre;
   private String description;
   private String recruteur;
   private Date datePublication;
   private String categorie;
   private String id;
   private String ville;
   private String photo;
   private String validation;
   
   
    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public void setRecruteurID(String id_recuteur) {
        this.id_recuteur = id_recuteur;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRecruteurID() {
        return id_recuteur;
    }

    public String getContact() {
        return contact;
    }

   
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
   
   
   public Offre(){
   }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
   
   
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecruteur(String recruteur) {
        this.recruteur = recruteur;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getRecruteur() {
        return recruteur;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setDatePublication(String datePublication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
           
    
}
