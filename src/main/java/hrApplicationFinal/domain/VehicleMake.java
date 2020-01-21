package hrApplicationFinal.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleMakeId", unique = true, nullable = false)
    private Integer id;

    @Version
    private Integer version;

    private String VehicleMakeName;
    private Date CreateDate;



    //CONSTRUCTORS
    public VehicleMake(){}
    public VehicleMake(int vehicleMakeId, String vehicleMakeName, Date createDate) {
        this.setId(vehicleMakeId);
        this.setVehicleMakeName(vehicleMakeName);
        this.setCreateDate(createDate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public String getVehicleMakeName() {
        return VehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        VehicleMakeName = vehicleMakeName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}