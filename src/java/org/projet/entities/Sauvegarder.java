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
public class Sauvegarder {
    private String id_sauvegarde;
    private String id_ensiaste;
    private String id_offre;

    public void setId_sauvegarde(String id_sauvegarde) {
        this.id_sauvegarde = id_sauvegarde;
    }

    public void setId_ensiaste(String id_ensiaste) {
        this.id_ensiaste = id_ensiaste;
    }

    public void setId_offre(String id_offre) {
        this.id_offre = id_offre;
    }

    
    public String getId_sauvegarde() {
        return id_sauvegarde;
    }

    public String getId_ensiaste() {
        return id_ensiaste;
    }

    public String getId_offre() {
        return id_offre;
    }
    
    
}
