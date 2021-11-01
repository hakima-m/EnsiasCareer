/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.projet.entities;

/**
 *
 * @author ASUS
 */
public class Employe {

    private String matricule;
    private String nom;
    private String prenom;
    private String service;

    
    
    public Employe(){
    }
    
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getService() {
        return service;
    }
    
    
    
}

    
    
    
    
    
  
