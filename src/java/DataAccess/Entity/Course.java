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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Course.findByCourseStartDate", query = "SELECT c FROM Course c WHERE c.courseStartDate = :courseStartDate"),
    @NamedQuery(name = "Course.findByCourseEndDate", query = "SELECT c FROM Course c WHERE c.courseEndDate = :courseEndDate"),
    @NamedQuery(name = "Course.findByCourseSchedule", query = "SELECT c FROM Course c WHERE c.courseSchedule = :courseSchedule"),
    @NamedQuery(name = "Course.findByCoursePrice", query = "SELECT c FROM Course c WHERE c.coursePrice = :coursePrice")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_id")
    private Integer courseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_start_date")
    @Temporal(TemporalType.DATE)
    private Date courseStartDate;
    @Column(name = "course_end_date")
    @Temporal(TemporalType.DATE)
    private Date courseEndDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "course_schedule")
    private String courseSchedule;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_price")
    private BigDecimal coursePrice;
    @ManyToMany(mappedBy = "courseCollection")
    private Collection<Administrator> administratorCollection;
    @JoinTable(name = "student_has_course", joinColumns = {
        @JoinColumn(name = "COURSE_course_id", referencedColumnName = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "STUDENT_est_id", referencedColumnName = "est_id")})
    @ManyToMany
    private Collection<Student> studentCollection;
    @JoinTable(name = "payment_has_course", joinColumns = {
        @JoinColumn(name = "COURSE_course_id", referencedColumnName = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "PAYMENT_pay_id", referencedColumnName = "pay_id")})
    @ManyToMany
    private Collection<Payment> paymentCollection;
    @ManyToMany(mappedBy = "courseCollection")
    private Collection<Administrative> administrativeCollection;
    @JoinTable(name = "teacher_has_course", joinColumns = {
        @JoinColumn(name = "COURSE_course_id", referencedColumnName = "course_id")}, inverseJoinColumns = {
        @JoinColumn(name = "TEACHER_teach_est_id", referencedColumnName = "teach_est_id")})
    @ManyToMany
    private Collection<Teacher> teacherCollection;
    @JoinColumn(name = "TEACHER_teach_est_id", referencedColumnName = "teach_est_id")
    @ManyToOne
    private Teacher tEACHERteachestid;

    public Course() {
    }

    public Course(Integer courseId) {
        this.courseId = courseId;
    }

    public Course(Integer courseId, String courseName, String courseSchedule, BigDecimal coursePrice) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseSchedule = courseSchedule;
        this.coursePrice = coursePrice;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public Date getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(Date courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    public String getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(String courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public BigDecimal getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(BigDecimal coursePrice) {
        this.coursePrice = coursePrice;
    }

    @XmlTransient
    public Collection<Administrator> getAdministratorCollection() {
        return administratorCollection;
    }

    public void setAdministratorCollection(Collection<Administrator> administratorCollection) {
        this.administratorCollection = administratorCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @XmlTransient
    public Collection<Administrative> getAdministrativeCollection() {
        return administrativeCollection;
    }

    public void setAdministrativeCollection(Collection<Administrative> administrativeCollection) {
        this.administrativeCollection = administrativeCollection;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    public Teacher getTEACHERteachestid() {
        return tEACHERteachestid;
    }

    public void setTEACHERteachestid(Teacher tEACHERteachestid) {
        this.tEACHERteachestid = tEACHERteachestid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Course[ courseId=" + courseId + " ]";
    }
    
}
