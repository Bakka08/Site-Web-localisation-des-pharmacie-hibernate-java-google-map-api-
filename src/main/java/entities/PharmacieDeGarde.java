/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hicham
 */
@Entity
public class PharmacieDeGarde {

    @EmbeddedId
    private PharmacieGardePK pk;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "garde", insertable = false, updatable = false)
    private Garde garde;
    @ManyToOne
    @JoinColumn(name = "pharmacie", insertable = false, updatable = false)
    private Pharmacie pharmacie;

    public PharmacieDeGarde() {
    }

    public PharmacieDeGarde(PharmacieGardePK pk, Date dateFin, Garde garde, Pharmacie pharmacie) {
        this.pk = pk;
        this.dateFin = dateFin;
        this.garde = garde;
        this.pharmacie = pharmacie;
    }

    public PharmacieGardePK getPk() {
        return pk;
    }

    public void setPk(PharmacieGardePK pk) {
        this.pk = pk;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

}
