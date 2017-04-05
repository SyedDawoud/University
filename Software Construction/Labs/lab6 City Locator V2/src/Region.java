
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dawoud Ali
 */

@Entity
@DiscriminatorValue(value="Region Level")
public class Region extends City{
    
    @Column(name="areaCode")
    private String areaCode;
    
    @Column(name="region")
    private String region;
    
    
    
    @Column(name="metroCode")
    private String metroCode;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    
    
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getMetroCode() {
        return metroCode;
    }

    public void setMetroCode(String metroCode) {
        this.metroCode = metroCode;
    }
}
