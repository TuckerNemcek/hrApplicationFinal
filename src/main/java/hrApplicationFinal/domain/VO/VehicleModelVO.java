package hrApplicationFinal.domain.VO;

import hrApplicationFinal.domain.VehicleMake;

public class VehicleModelVO {
    private Integer id;
    private String newVehicleModelName;

    private VehicleMake vehicleMake;

    public VehicleModelVO () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewVehicleModelName() {
        return newVehicleModelName;
    }

    public void setNewVehicleModelName(String newVehicleModelName) {
        this.newVehicleModelName = newVehicleModelName;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
}
