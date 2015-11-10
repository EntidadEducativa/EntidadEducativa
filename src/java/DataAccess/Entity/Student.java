/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByEstId", query = "SELECT s FROM Student s WHERE s.estId = :estId"),
    @NamedQuery(name = "Student.findByEstDocument", query = "SELECT s FROM Student s WHERE s.estDocument = :estDocument"),
    @NamedQuery(name = "Student.findByEstUsername", query = "SELECT s FROM Student s WHERE s.estUsername = :estUsername"),
    @NamedQuery(name = "Student.findByEstName", query = "SELECT s FROM Student s WHERE s.estName = :estName"),
    @NamedQuery(name = "Student.findByEstLastName", query = "SELECT s FROM Student s WHERE s.estLastName = :estLastName"),
    @NamedQuery(name = "Student.findByEstPassword", query = "SELECT s FROM Student s WHERE s.estPassword = :estPassword"),
    @NamedQuery(name = "Student.findByEstEmail", query = "SELECT s FROM Student s WHERE s.estEmail = :estEmail"),
    @NamedQuery(name = "Student.findByEstTelephone", query = "SELECT s FROM Student s WHERE s.estTelephone = :estTelephone"),
    @NamedQuery(name = "Student.findByEstAddress", query = "SELECT s FROM Student s WHERE s.estAddress = :estAddress"),
    @NamedQuery(name = "Student.findByEstAge", query = "SELECT s FROM Student s WHERE s.estAge = :estAge"),
    @NamedQuery(name = "Student.findByEstGender", query = "SELECT s FROM Student s WHERE s.estGender = :estGender"),
    @NamedQuery(name = "Student.findByEstRoll", query = "SELECT s FROM Student s WHERE s.estRoll = :estRoll"),
    @NamedQuery(name = "Student.findByEstBenefit", query = "SELECT s FROM Student s WHERE s.estBenefit = :estBenefit")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_id")
    private Integer estId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_document")
    private long estDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "est_username")
    private String estUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_name")
    private String estName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_last_name")
    private String estLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "est_password")
    private String estPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "est_email")
    private String estEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_telephone")
    private long estTelephone;
    @Size(max = 20)
    @Column(name = "est_address")
    private String estAddress;
    @Column(name = "est_age")
    private Integer estAge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "est_gender")
    private String estGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_roll")
    private String estRoll;
    @Size(max = 10)
    @Column(name = "est_benefit")
    private String estBenefit;
    @ManyToMany(mappedBy = "studentCollection")
    private Collection<Administrator> administratorCollection;
    @ManyToMany(mappedBy = "studentCollection")
    private Collection<Course> courseCollection;
    @OneToMany(mappedBy = "sTUDENTestid")
    private Collection<Payment> paymentCollection;

    public Student() {
    }

    public Student(Integer estId) {
        this.estId = estId;
    }

    public Student(Integer estId, long estDocument, String estUsername, String estName, String estLastName, String estPassword, String estEmail, long estTelephone, String estGender, String estRoll) {
        this.estId = estId;
        this.estDocument = estDocument;
        this.estUsername = estUsername;
        this.estName = estName;
        this.estLastName = estLastName;
        this.estPassword = estPassword;
        this.estEmail = estEmail;
        this.estTelephone = estTelephone;
        this.estGender = estGender;
        this.estRoll = estRoll;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public long getEstDocument() {
        return estDocument;
    }

    public void setEstDocument(long estDocument) {
        this.estDocument = estDocument;
    }

    public String getEstUsername() {
        return estUsername;
    }

    public void setEstUsername(String estUsername) {
        this.estUsername = estUsername;
    }

    public String getEstName() {
        return estName;
    }

    public void setEstName(String estName) {
        this.estName = estName;
    }

    public String getEstLastName() {
        return estLastName;
    }

    public void setEstLastName(String estLastName) {
        this.estLastName = estLastName;
    }

    public String getEstPassword() {
        return estPassword;
    }

    public void setEstPassword(String estPassword) {
        this.estPassword = estPassword;
    }

    public String getEstEmail() {
        return estEmail;
    }

    public void setEstEmail(String estEmail) {
        this.estEmail = estEmail;
    }

    public long getEstTelephone() {
        return estTelephone;
    }

    public void setEstTelephone(long estTelephone) {
        this.estTelephone = estTelephone;
    }

    public String getEstAddress() {
        return estAddress;
    }

    public void setEstAddress(String estAddress) {
        this.estAddress = estAddress;
    }

    public Integer getEstAge() {
        return estAge;
    }

    public void setEstAge(Integer estAge) {
        this.estAge = estAge;
    }

    public String getEstGender() {
        return estGender;
    }

    public void setEstGender(String estGender) {
        this.estGender = estGender;
    }

    public String getEstRoll() {
        return estRoll;
    }

    public void setEstRoll(String estRoll) {
        this.estRoll = estRoll;
    }

    public String getEstBenefit() {
        return estBenefit;
    }

    public void setEstBenefit(String estBenefit) {
        this.estBenefit = estBenefit;
    }

    @XmlTransient
    public Collection<Administrator> getAdministratorCollection() {
        return administratorCollection;
    }

    public void setAdministratorCollection(Collection<Administrator> administratorCollection) {
        this.administratorCollection = administratorCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
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
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Student[ estId=" + estId + " ]";
    }
    
}
