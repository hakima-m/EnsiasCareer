package org.projet.entities;
public class Entreprise extends Compte {
    
    
    /*private String typeCompte;
    private String login;
    private String mdp;
    private String email;*/
    private String id;
    private String raisonSocial;
    private String nomMarque;
    private String statutJuridique;
    private String capital;
    private String effectif;
    private String cheminPhoto;
    private String domaine;
    private String validation;

    public Entreprise() {
    }
    
    
    
    public Entreprise(String id, String raisonSocial, String nomMarque, String statutJuridique, String capital, String effectif, String domaine, String validation) {
        this.id = id;
        this.raisonSocial = raisonSocial;
        this.nomMarque = nomMarque;
        this.statutJuridique = statutJuridique;
        this.capital = capital;
        this.effectif = effectif;
        this.domaine = domaine;
        this.validation = validation;
    }

    /*public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    public String getTypeCompte() {
        return typeCompte;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public String getEmail() {
        return email;
    }*/

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    
    
    

   
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setEffectif(String effectif) {
        this.effectif = effectif;
    }

    public void setCheminPhoto(String cheminPhoto) {
        this.cheminPhoto = cheminPhoto;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public String getStatutJuridique() {
        return statutJuridique;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public void setStatutJuridique(String statutJuridique) {
        this.statutJuridique = statutJuridique;
    }

    

   
    public String getCapital() {
        return capital;
    }

    public String getEffectif() {
        return effectif;
    }

    public String getCheminPhoto() {
        return cheminPhoto;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
