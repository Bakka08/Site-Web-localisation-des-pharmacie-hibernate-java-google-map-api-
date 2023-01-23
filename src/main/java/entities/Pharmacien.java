/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author hicham
 */
@Entity
public class Pharmacien extends User{
    private String email;
    private String prenom;
    private String telephone;
    @OneToMany (mappedBy = "pharmacien",  fetch = FetchType.EAGER)
    private List<Pharmacie> pharmcies;

    public Pharmacien() {
    }

    public Pharmacien(String email, String prenom, String telephone, String login, String password) {
        super(login, password);
        this.email = email;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    
    
    
}
