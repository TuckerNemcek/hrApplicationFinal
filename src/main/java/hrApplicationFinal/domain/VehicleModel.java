package hrApplicationFinal.domain;

import javax.persistence.*;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer id;

    private String VehicleModelName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private VehicleMake vehicleMake;

    @Version
    private Integer version;


    public VehicleModel(){}
    public VehicleModel(int vehicleModelId, String vehicleModelName, VehicleMake vehicleMake) {
        this.setVeModelId(vehicleModelId);
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleMake(vehicleMake);
    }

    public Integer getId() {
        return id;
    }

    public void setVeModelId(Integer id) {
        this.id = id;
    }

    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}