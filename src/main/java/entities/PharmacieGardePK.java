/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author hicham
 */
@Embeddable
public class PharmacieGardePK implements Serializable{
    private int pharmacie;
    private int garde;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    public PharmacieGardePK() {
    }
    
    public PharmacieGardePK(int pharmacie , int garde , Date datedebut) {
    	this.pharmacie=pharmacie;
    	this.dateDebut=datedebut;
    	this.garde=garde;
    }


    public int getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(int pharmacie) {
        this.pharmacie = pharmacie;
    }

    public int getGarde() {
        return garde;
    }

    public void setGarde(int garde) {
        this.garde = garde;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
}
