/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
@Entity
@Table(name = "ADMINISTRATIVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrative.findAll", query = "SELECT a FROM Administrative a"),
    @NamedQuery(name = "Administrative.findByAdmEstId", query = "SELECT a FROM Administrative a WHERE a.admEstId = :admEstId"),
    @NamedQuery(name = "Administrative.findByAdmDocument", query = "SELECT a FROM Administrative a WHERE a.admDocument = :admDocument"),
    @NamedQuery(name = "Administrative.findByAdmUsername", query = "SELECT a FROM Administrative a WHERE a.admUsername = :admUsername"),
    @NamedQuery(name = "Administrative.findByAdmName", query = "SELECT a FROM Administrative a WHERE a.admName = :admName"),
    @NamedQuery(name = "Administrative.findByAdmLastName", query = "SELECT a FROM Administrative a WHERE a.admLastName = :admLastName"),
    @NamedQuery(name = "Administrative.findByAdmPassword", query = "SELECT a FROM Administrative a WHERE a.admPassword = :admPassword"),
    @NamedQuery(name = "Administrative.findByAdmEmail", query = "SELECT a FROM Administrative a WHERE a.admEmail = :admEmail"),
    @NamedQuery(name = "Administrative.findByAdmTelephone", query = "SELECT a FROM Administrative a WHERE a.admTelephone = :admTelephone"),
    @NamedQuery(name = "Administrative.findByAdmAddress", query = "SELECT a FROM Administrative a WHERE a.admAddress = :admAddress"),
    @NamedQuery(name = "Administrative.findByAdmBirthday", query = "SELECT a FROM Administrative a WHERE a.admBirthday = :admBirthday"),
    @NamedQuery(name = "Administrative.findByAdmGender", query = "SELECT a FROM Administrative a WHERE a.admGender = :admGender"),
    @NamedQuery(name = "Administrative.findByAdmRoll", query = "SELECT a FROM Administrative a WHERE a.admRoll = :admRoll"),
    @NamedQuery(name = "Administrative.findByAdmPosition", query = "SELECT a FROM Administrative a WHERE a.admPosition = :admPosition"),
    @NamedQuery(name = "Administrative.findByAdmDependence", query = "SELECT a FROM Administrative a WHERE a.admDependence = :admDependence")})
public class Administrative implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adm_est_id")
    private Integer admEstId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "adm_document")
    private long admDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "adm_username")
    private String admUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adm_name")
    private String admName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adm_last_name")
    private String admLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "adm_password")
    private String admPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "adm_email")
    private String admEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "adm_telephone")
    private long admTelephone;
    @Size(max = 20)
    @Column(name = "adm_address")
    private String admAddress;
    @Column(name = "adm_birthday")
    @Temporal(TemporalType.DATE)
    private Date admBirthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "adm_gender")
    private String admGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adm_roll")
    private String admRoll;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adm_position")
    private String admPosition;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adm_dependence")
    private String admDependence;
    @OneToMany(mappedBy = "aDMINISTRATIVEadmestid1")
    private Collection<Payment> paymentCollection;

    public Administrative() {
    }

    public Administrative(Integer admEstId) {
        this.admEstId = admEstId;
    }

    public Administrative(Integer admEstId, long admDocument, String admUsername, String admName, String admLastName, String admPassword, String admEmail, long admTelephone, String admGender, String admRoll, String admPosition, String admDependence) {
        this.admEstId = admEstId;
        this.admDocument = admDocument;
        this.admUsername = admUsername;
        this.admName = admName;
        this.admLastName = admLastName;
        this.admPassword = admPassword;
        this.admEmail = admEmail;
        this.admTelephone = admTelephone;
        this.admGender = admGender;
        this.admRoll = admRoll;
        this.admPosition = admPosition;
        this.admDependence = admDependence;
    }

    public Integer getAdmEstId() {
        return admEstId;
    }

    public void setAdmEstId(Integer admEstId) {
        this.admEstId = admEstId;
    }

    public long getAdmDocument() {
        return admDocument;
    }

    public void setAdmDocument(long admDocument) {
        this.admDocument = admDocument;
    }

    public String getAdmUsername() {
        return admUsername;
    }

    public void setAdmUsername(String admUsername) {
        this.admUsername = admUsername;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAdmLastName() {
        return admLastName;
    }

    public void setAdmLastName(String admLastName) {
        this.admLastName = admLastName;
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword;
    }

    public String getAdmEmail() {
        return admEmail;
    }

    public void setAdmEmail(String admEmail) {
        this.admEmail = admEmail;
    }

    public long getAdmTelephone() {
        return admTelephone;
    }

    public void setAdmTelephone(long admTelephone) {
        this.admTelephone = admTelephone;
    }

    public String getAdmAddress() {
        return admAddress;
    }

    public void setAdmAddress(String admAddress) {
        this.admAddress = admAddress;
    }

    public Date getAdmBirthday() {
        return admBirthday;
    }

    public void setAdmBirthday(Date admBirthday) {
        this.admBirthday = admBirthday;
    }

    public String getAdmGender() {
        return admGender;
    }

    public void setAdmGender(String admGender) {
        this.admGender = admGender;
    }

    public String getAdmRoll() {
        return admRoll;
    }

    public void setAdmRoll(String admRoll) {
        this.admRoll = admRoll;
    }

    public String getAdmPosition() {
        return admPosition;
    }

    public void setAdmPosition(String admPosition) {
        this.admPosition = admPosition;
    }

    public String getAdmDependence() {
        return admDependence;
    }

    public void setAdmDependence(String admDependence) {
        this.admDependence = admDependence;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admEstId != null ? admEstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrative)) {
            return false;
        }
        Administrative other = (Administrative) object;
        if ((this.admEstId == null && other.admEstId != null) || (this.admEstId != null && !this.admEstId.equals(other.admEstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Administrative[ admEstId=" + admEstId + " ]";
    }
    
}
