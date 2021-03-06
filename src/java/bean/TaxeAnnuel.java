/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ayoub
 */
@Entity
public class TaxeAnnuel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double taxeTotale;
    private int nbrTrimesterPaye;
    @OneToMany(mappedBy = "taxeAnnuel")
    private List<TaxeTrim> taxeTrims;
    private int annee;
    @ManyToOne
    private Locale locale;

    public Double getTaxeTotale() {
        return taxeTotale;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setTaxeTotale(Double taxeTotale) {
        this.taxeTotale = taxeTotale;
    }

    public TaxeAnnuel() {
    }

    public List<TaxeTrim> getTaxeTrims() {
        return taxeTrims;
    }

    public void setTaxeTrims(List<TaxeTrim> taxeTrims) {
        this.taxeTrims = taxeTrims;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxeAnnuel)) {
            return false;
        }
        TaxeAnnuel other = (TaxeAnnuel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.TaxeAnnuel[ id=" + id + " ]";
    }

    public int getNbrTrimesterPaye() {
        return nbrTrimesterPaye;
    }

    public void setNbrTrimesterPaye(int nbrTrimesterPaye) {
        this.nbrTrimesterPaye = nbrTrimesterPaye;
    }

}
