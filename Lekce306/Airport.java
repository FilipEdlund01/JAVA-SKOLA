/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lekce306;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2019-e-edlund
 */
@Entity
@Table(name = "airport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a")
    , @NamedQuery(name = "Airport.findById", query = "SELECT a FROM Airport a WHERE a.id = :id")
    , @NamedQuery(name = "Airport.findByName", query = "SELECT a FROM Airport a WHERE a.name = :name")
    , @NamedQuery(name = "Airport.findByCity", query = "SELECT a FROM Airport a WHERE a.city = :city")
    , @NamedQuery(name = "Airport.findByCountry", query = "SELECT a FROM Airport a WHERE a.country = :country")
    , @NamedQuery(name = "Airport.findByIataFaa", query = "SELECT a FROM Airport a WHERE a.iataFaa = :iataFaa")
    , @NamedQuery(name = "Airport.findByIcao", query = "SELECT a FROM Airport a WHERE a.icao = :icao")
    , @NamedQuery(name = "Airport.findByLatitude", query = "SELECT a FROM Airport a WHERE a.latitude = :latitude")
    , @NamedQuery(name = "Airport.findByLongitude", query = "SELECT a FROM Airport a WHERE a.longitude = :longitude")
    , @NamedQuery(name = "Airport.findByAltitude", query = "SELECT a FROM Airport a WHERE a.altitude = :altitude")
    , @NamedQuery(name = "Airport.findByTimezone", query = "SELECT a FROM Airport a WHERE a.timezone = :timezone")
    , @NamedQuery(name = "Airport.findByDst", query = "SELECT a FROM Airport a WHERE a.dst = :dst")})
public class Airport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @Column(name = "iata_faa")
    private String iataFaa;
    @Basic(optional = false)
    @Column(name = "icao")
    private String icao;
    @Basic(optional = false)
    @Column(name = "latitude")
    private float latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private float longitude;
    @Basic(optional = false)
    @Column(name = "altitude")
    private float altitude;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "timezone")
    private BigDecimal timezone;
    @Basic(optional = false)
    @Column(name = "dst")
    private String dst;

    public Airport() {
    }

    public Airport(Integer id) {
        this.id = id;
    }

    public Airport(Integer id, String name, String city, String country, String iataFaa, String icao, float latitude, float longitude, float altitude, BigDecimal timezone, String dst) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iataFaa = iataFaa;
        this.icao = icao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.dst = dst;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIataFaa() {
        return iataFaa;
    }

    public void setIataFaa(String iataFaa) {
        this.iataFaa = iataFaa;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public BigDecimal getTimezone() {
        return timezone;
    }

    public void setTimezone(BigDecimal timezone) {
        this.timezone = timezone;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
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
        if (!(object instanceof Airport)) {
            return false;
        }
        Airport other = (Airport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lekce306.Airport[ id=" + id + " ]";
    }
    
}
