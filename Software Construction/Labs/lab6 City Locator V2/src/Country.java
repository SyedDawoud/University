import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;




@Entity
@Table(name="Record")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="currentLevel",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="Country Level")

public class Country {
    
    @Id
    @Column(name="Id")
    private int Id;
    
    @Column(name="country")
    private String country;
    
    @Column(name="Longitude")
    private float Longitude;
    
    @Column(name="Latitude")
    private float Latitude;
    
    @Column(name="postalCode")
    private String postalCode;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float Latitude) {
        this.Latitude = Latitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
     
}




