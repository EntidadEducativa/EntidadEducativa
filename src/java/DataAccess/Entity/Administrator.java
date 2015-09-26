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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergioalejandrodiazpinilla
 */
@Entity
@Table(name = "ADMINISTRATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByAdminId", query = "SELECT a FROM Administrator a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "Administrator.findByAdminName", query = "SELECT a FROM Administrator a WHERE a.adminName = :adminName"),
    @NamedQuery(name = "Administrator.findByAdminUsername", query = "SELECT a FROM Administrator a WHERE a.adminUsername = :adminUsername"),
    @NamedQuery(name = "Administrator.findByAdminPassword", query = "SELECT a FROM Administrator a WHERE a.adminPassword = :adminPassword"),
    @NamedQuery(name = "Administrator.findByAdminLastname", query = "SELECT a FROM Administrator a WHERE a.adminLastname = :adminLastname")})
public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
    private Integer adminId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "admin_name")
    private String adminName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "admin_username")
    private String adminUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "admin_password")
    private String adminPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "admin_lastname")
    private String adminLastname;
    @JoinTable(name = "ADMINISTRATOR_has_COURSE", joinColumns = {
        @JoinColumn(name = "ADMINISTRATOR_admin_id", referencedColumnName = "admin_id")}, inverseJoinColumns = {
        @JoinColumn(name = "COURSE_course_id", referencedColumnName = "course_id")})
    @ManyToMany
    private Collection<Course> courseCollection;
    @JoinTable(name = "ADMINISTRATOR_has_TEACHER", joinColumns = {
        @JoinColumn(name = "ADMINISTRATOR_admin_id", referencedColumnName = "admin_id")}, inverseJoinColumns = {
        @JoinColumn(name = "TEACHER_teach_est_id", referencedColumnName = "teach_est_id")})
    @ManyToMany
    private Collection<Teacher> teacherCollection;
    @JoinTable(name = "ADMINISTRATOR_has_STUDENT", joinColumns = {
        @JoinColumn(name = "ADMINISTRATOR_admin_id", referencedColumnName = "admin_id")}, inverseJoinColumns = {
        @JoinColumn(name = "STUDENT_est_id", referencedColumnName = "est_id")})
    @ManyToMany
    private Collection<Student> studentCollection;
    @ManyToMany(mappedBy = "administratorCollection")
    private Collection<Administrative> administrativeCollection;

    public Administrator() {
    }

    public Administrator(Integer adminId) {
        this.adminId = adminId;
    }

    public Administrator(Integer adminId, String adminName, String adminUsername, String adminPassword, String adminLastname) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.adminLastname = adminLastname;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminLastname() {
        return adminLastname;
    }

    public void setAdminLastname(String adminLastname) {
        this.adminLastname = adminLastname;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Administrative> getAdministrativeCollection() {
        return administrativeCollection;
    }

    public void setAdministrativeCollection(Collection<Administrative> administrativeCollection) {
        this.administrativeCollection = administrativeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Administrator[ adminId=" + adminId + " ]";
    }
    
}
