/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TEACHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeachEstId", query = "SELECT t FROM Teacher t WHERE t.teachEstId = :teachEstId"),
    @NamedQuery(name = "Teacher.findByTeachDocument", query = "SELECT t FROM Teacher t WHERE t.teachDocument = :teachDocument"),
    @NamedQuery(name = "Teacher.findByTeachUsername", query = "SELECT t FROM Teacher t WHERE t.teachUsername = :teachUsername"),
    @NamedQuery(name = "Teacher.findByTeachName", query = "SELECT t FROM Teacher t WHERE t.teachName = :teachName"),
    @NamedQuery(name = "Teacher.findByTeachLastName", query = "SELECT t FROM Teacher t WHERE t.teachLastName = :teachLastName"),
    @NamedQuery(name = "Teacher.findByTeachPassword", query = "SELECT t FROM Teacher t WHERE t.teachPassword = :teachPassword"),
    @NamedQuery(name = "Teacher.findByTeachEmail", query = "SELECT t FROM Teacher t WHERE t.teachEmail = :teachEmail"),
    @NamedQuery(name = "Teacher.findByTeachTelephone", query = "SELECT t FROM Teacher t WHERE t.teachTelephone = :teachTelephone"),
    @NamedQuery(name = "Teacher.findByTeachAddress", query = "SELECT t FROM Teacher t WHERE t.teachAddress = :teachAddress"),
    @NamedQuery(name = "Teacher.findByTeachBirthday", query = "SELECT t FROM Teacher t WHERE t.teachBirthday = :teachBirthday"),
    @NamedQuery(name = "Teacher.findByTeachGender", query = "SELECT t FROM Teacher t WHERE t.teachGender = :teachGender"),
    @NamedQuery(name = "Teacher.findByTeachRoll", query = "SELECT t FROM Teacher t WHERE t.teachRoll = :teachRoll"),
    @NamedQuery(name = "Teacher.findByTeachProfile", query = "SELECT t FROM Teacher t WHERE t.teachProfile = :teachProfile"),
    @NamedQuery(name = "Teacher.findByTeachSalary", query = "SELECT t FROM Teacher t WHERE t.teachSalary = :teachSalary")})
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teach_est_id")
    private Integer teachEstId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teach_document")
    private long teachDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "teach_username")
    private String teachUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teach_name")
    private String teachName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teach_last_name")
    private String teachLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "teach_password")
    private String teachPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "teach_email")
    private String teachEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teach_telephone")
    private long teachTelephone;
    @Size(max = 20)
    @Column(name = "teach_address")
    private String teachAddress;
    @Column(name = "teach_birthday")
    @Temporal(TemporalType.DATE)
    private Date teachBirthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "teach_gender")
    private String teachGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teach_roll")
    private String teachRoll;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "teach_profile")
    private String teachProfile;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "teach_salary")
    private BigDecimal teachSalary;
    @OneToMany(mappedBy = "tEACHERteachestid")
    private Collection<Payment> paymentCollection;

    public Teacher() {
    }

    public Teacher(Integer teachEstId) {
        this.teachEstId = teachEstId;
    }

    public Teacher(Integer teachEstId, long teachDocument, String teachUsername, String teachName, String teachLastName, String teachPassword, String teachEmail, long teachTelephone, String teachGender, String teachRoll, String teachProfile, BigDecimal teachSalary) {
        this.teachEstId = teachEstId;
        this.teachDocument = teachDocument;
        this.teachUsername = teachUsername;
        this.teachName = teachName;
        this.teachLastName = teachLastName;
        this.teachPassword = teachPassword;
        this.teachEmail = teachEmail;
        this.teachTelephone = teachTelephone;
        this.teachGender = teachGender;
        this.teachRoll = teachRoll;
        this.teachProfile = teachProfile;
        this.teachSalary = teachSalary;
    }

    public Integer getTeachEstId() {
        return teachEstId;
    }

    public void setTeachEstId(Integer teachEstId) {
        this.teachEstId = teachEstId;
    }

    public long getTeachDocument() {
        return teachDocument;
    }

    public void setTeachDocument(long teachDocument) {
        this.teachDocument = teachDocument;
    }

    public String getTeachUsername() {
        return teachUsername;
    }

    public void setTeachUsername(String teachUsername) {
        this.teachUsername = teachUsername;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getTeachLastName() {
        return teachLastName;
    }

    public void setTeachLastName(String teachLastName) {
        this.teachLastName = teachLastName;
    }

    public String getTeachPassword() {
        return teachPassword;
    }

    public void setTeachPassword(String teachPassword) {
        this.teachPassword = teachPassword;
    }

    public String getTeachEmail() {
        return teachEmail;
    }

    public void setTeachEmail(String teachEmail) {
        this.teachEmail = teachEmail;
    }

    public long getTeachTelephone() {
        return teachTelephone;
    }

    public void setTeachTelephone(long teachTelephone) {
        this.teachTelephone = teachTelephone;
    }

    public String getTeachAddress() {
        return teachAddress;
    }

    public void setTeachAddress(String teachAddress) {
        this.teachAddress = teachAddress;
    }

    public Date getTeachBirthday() {
        return teachBirthday;
    }

    public void setTeachBirthday(Date teachBirthday) {
        this.teachBirthday = teachBirthday;
    }

    public String getTeachGender() {
        return teachGender;
    }

    public void setTeachGender(String teachGender) {
        this.teachGender = teachGender;
    }

    public String getTeachRoll() {
        return teachRoll;
    }

    public void setTeachRoll(String teachRoll) {
        this.teachRoll = teachRoll;
    }

    public String getTeachProfile() {
        return teachProfile;
    }

    public void setTeachProfile(String teachProfile) {
        this.teachProfile = teachProfile;
    }

    public BigDecimal getTeachSalary() {
        return teachSalary;
    }

    public void setTeachSalary(BigDecimal teachSalary) {
        this.teachSalary = teachSalary;
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
        hash += (teachEstId != null ? teachEstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teachEstId == null && other.teachEstId != null) || (this.teachEstId != null && !this.teachEstId.equals(other.teachEstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Teacher[ teachEstId=" + teachEstId + " ]";
    }
    
}
