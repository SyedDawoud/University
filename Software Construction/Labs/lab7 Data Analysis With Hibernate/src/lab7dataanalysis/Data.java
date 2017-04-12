
package lab7dataanalysis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dawoud Ali
 */
@Entity
@Table(name="Data")
public class Data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="id")
    private int id;
    
    @Column(name="userId")
    private String userid;
    
    @Column(name="Scheme")
    private String scheme;
    
    @Column(name="TotalTime")
    private float timeTotal;
    @Column(name="TotalStatus")
    private String statusFinal;
    
    @Column(name="time1")
    private float time1;
    @Column(name="status1")
    private String status1;
    
    
    @Column(name="time2")
    private float time2;
    @Column(name="status2")
    private String status2;
    
    @Column(name="time3")
    private float time3;
    @Column(name="status3")
    private String status3;
    
    @Column(name="time4")
    private float time4;
    @Column(name="status4")
    private String status4;
    
    @Column(name="time5")
    private float time5;
    @Column(name="status5")
    private String status5;
    
    @Column(name="time6")
    private float time6;
    @Column(name="status6")
    private String status6;
    
    @Column(name="time7")
    private float time7;
    @Column(name="status7")
    private String status7;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public float getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(float timeTotal) {
        this.timeTotal = timeTotal;
    }

    public String getStatusFinal() {
        return statusFinal;
    }

    public void setStatusFinal(String statusFinal) {
        this.statusFinal = statusFinal;
    }

    public float getTime1() {
        return time1;
    }

    public void setTime1(float time1) {
        this.time1 = time1;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public float getTime2() {
        return time2;
    }

    public void setTime2(float time2) {
        this.time2 = time2;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public float getTime3() {
        return time3;
    }

    public void setTime3(float time3) {
        this.time3 = time3;
    }

    public String getStatus3() {
        return status3;
    }

    public void setStatus3(String status3) {
        this.status3 = status3;
    }

    public float getTime4() {
        return time4;
    }

    public void setTime4(float time4) {
        this.time4 = time4;
    }

    public String getStatus4() {
        return status4;
    }

    public void setStatus4(String status4) {
        this.status4 = status4;
    }

    public float getTime5() {
        return time5;
    }

    public void setTime5(float time5) {
        this.time5 = time5;
    }

    public String getStatus5() {
        return status5;
    }

    public void setStatus5(String status5) {
        this.status5 = status5;
    }

    public float getTime6() {
        return time6;
    }

    public void setTime6(float time6) {
        this.time6 = time6;
    }

    public String getStatus6() {
        return status6;
    }

    public void setStatus6(String status6) {
        this.status6 = status6;
    }

    public float getTime7() {
        return time7;
    }

    public void setTime7(float time7) {
        this.time7 = time7;
    }

    public String getStatus7() {
        return status7;
    }

    public void setStatus7(String status7) {
        this.status7 = status7;
    }
    
    
    
    
    
    
    
}
