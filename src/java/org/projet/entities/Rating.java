/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.projet.entities;

/**
 *
 * @author acer
 */
public class Rating {
    private int id;
    private float rateindex;
    private int id_ensiaste;
    private int id_offre;

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public float getRateindex() {
        return rateindex;
    }

    public void setRateindex(float rateindex) {
        this.rateindex = rateindex;
    }

    

    public int getId_ensiaste() {
        return id_ensiaste;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    

    public void setId_ensiaste(int id_ensiaste) {
        this.id_ensiaste = id_ensiaste;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    
    
    
}
