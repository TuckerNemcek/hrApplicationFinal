package hrApplicationFinal.domain.VO;

import java.util.Date;

public class VehicleMakeVO {
    private String newVehicleMakeName;
    private Date newVehicleMakeCreateDate;

    public VehicleMakeVO () {}

    public String getNewVehicleMakeName() {
        return newVehicleMakeName;
    }

    public void setNewVehicleMakeName(String newVehicleMakeName) {
        this.newVehicleMakeName = newVehicleMakeName;
    }

    public Date getNewVehicleMakeCreateDate() {
        return newVehicleMakeCreateDate;
    }

    public void setNewVehicleMakeCreateDate(Date newVehicleMakeCreateDate) {
        this.newVehicleMakeCreateDate = newVehicleMakeCreateDate;
    }
}
