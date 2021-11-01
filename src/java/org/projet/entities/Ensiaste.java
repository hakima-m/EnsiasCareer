package org.projet.entities;

import java.io.InputStream;
import javax.servlet.http.Part;




public class Ensiaste extends Compte{
private String id;
private String nom;
private String prenom;
private String CNE;
private String ville;
private String filiere;
private String annee;
/*private String login;
private String mdp;*/
private String chemin;
private String contact;

private String validation;

    public Ensiaste() {
    }
    
    
    public Ensiaste(String id, String nom, String prenom, String CNE, String ville, String filiere, String annee, String validation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.CNE = CNE;
        this.ville = ville;
        this.filiere = filiere;
        this.annee = annee;
        this.validation = validation;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }


/*private Part savePath;*/

    
    /*public Part getSavePath() {
        return savePath;
    }

    public void setSavePath(Part savePath) {
        this.savePath = savePath;
    }*/

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

   


    public String getId() {
        return id;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getVille() {
        return ville;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

   /* public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
*/
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCNE() {
        return CNE;
    }

    public String getFiliere() {
        return filiere;
    }

    public String getAnnee() {
        return annee;
    }

/*    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }
*/



}
