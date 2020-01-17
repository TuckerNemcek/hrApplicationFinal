package hrApplicationFinal.domain.VO;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class VehicleMakeVO {

    private Integer id;
    private String newVehicleMakeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date newVehicleMakeCreateDate;

    public VehicleMakeVO () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewVehicleMakeName() { return newVehicleMakeName; }
    public void setNewVehicleMakeName(String newVehicleMakeName) {
        this.newVehicleMakeName = newVehicleMakeName;
    }

    public Date getNewVehicleMakeCreateDate() { return newVehicleMakeCreateDate; }
    public void setNewVehicleMakeCreateDate(Date newVehicleMakeCreateDate) {
        this.newVehicleMakeCreateDate = newVehicleMakeCreateDate;
    }
}
