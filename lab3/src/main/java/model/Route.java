/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Flight;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utkin
 */
@Entity
@Table(name = "Route")
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "Number", length = 25)
    private String number;
    
    @Column(name = "InstalStop", length = 25)
    private String instalStop;
    
    @Column(name = "FinalStop", length = 25)
    private String finalStop;
    
    @OneToMany(mappedBy = "id_route")
    private Collection<Flight> flightCollection;

    public Route() {
    }

    public Route(Integer id) {
        this.id = id;
    }

    public Route(Integer id, String number, String instalStop, String finalStop) {
        this.id = id;
        this.number = number;
        this.instalStop = instalStop;
        this.finalStop = finalStop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInstalStop() {
        return instalStop;
    }

    public void setInstalStop(String instalStop) {
        this.instalStop = instalStop;
    }

    public String getFinalStop() {
        return finalStop;
    }

    public void setFinalStop(String finalStop) {
        this.finalStop = finalStop;
    }
    
    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }
    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
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
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Route[ id=" + id + " ]";
    }    
}
