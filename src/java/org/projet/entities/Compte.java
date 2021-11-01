package org.projet.entities;

public class Compte {
    private String typeCompte;
    private String login;
    private String mdp;
    private String email;

    public Compte() {
    }
    
    public Compte(String typeCompte, String login, String mdp, String email) {
        this.typeCompte = typeCompte;
        this.login = login;
        this.mdp = mdp;
        this.email = email;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    public void  sincrire() {
    }
    public void modifier() {
    }
    public void sautentifier() {
    }
    public void supprimer() {
    }
    public void valider() {
    }
}
