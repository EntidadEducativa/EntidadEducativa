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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPayId", query = "SELECT p FROM Payment p WHERE p.payId = :payId"),
    @NamedQuery(name = "Payment.findByPayValue", query = "SELECT p FROM Payment p WHERE p.payValue = :payValue"),
    @NamedQuery(name = "Payment.findByPayDate", query = "SELECT p FROM Payment p WHERE p.payDate = :payDate")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pay_id")
    private Long payId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pay_value")
    private BigDecimal payValue;
    @Column(name = "pay_date")
    @Temporal(TemporalType.DATE)
    private Date payDate;
    @ManyToMany(mappedBy = "paymentCollection")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "ADMINISTRATIVE_adm_est_id1", referencedColumnName = "adm_est_id")
    @ManyToOne
    private Administrative aDMINISTRATIVEadmestid1;
    @JoinColumn(name = "STUDENT_est_id", referencedColumnName = "est_id")
    @ManyToOne
    private Student sTUDENTestid;
    @JoinColumn(name = "TEACHER_teach_est_id", referencedColumnName = "teach_est_id")
    @ManyToOne
    private Teacher tEACHERteachestid;

    public Payment() {
    }

    public Payment(Long payId) {
        this.payId = payId;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public BigDecimal getPayValue() {
        return payValue;
    }

    public void setPayValue(BigDecimal payValue) {
        this.payValue = payValue;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public Administrative getADMINISTRATIVEadmestid1() {
        return aDMINISTRATIVEadmestid1;
    }

    public void setADMINISTRATIVEadmestid1(Administrative aDMINISTRATIVEadmestid1) {
        this.aDMINISTRATIVEadmestid1 = aDMINISTRATIVEadmestid1;
    }

    public Student getSTUDENTestid() {
        return sTUDENTestid;
    }

    public void setSTUDENTestid(Student sTUDENTestid) {
        this.sTUDENTestid = sTUDENTestid;
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
        hash += (payId != null ? payId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.payId == null && other.payId != null) || (this.payId != null && !this.payId.equals(other.payId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Payment[ payId=" + payId + " ]";
    }
    
}
