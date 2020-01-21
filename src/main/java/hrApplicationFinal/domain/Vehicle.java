package hrApplicationFinal.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId", unique = true, nullable = false)
    private Integer id;

    @Version
    private Integer version;

    private Date YearProduced;
    private String LicensePlate;
    private String Vin;
    private String Color;

    @OneToOne(fetch = FetchType.EAGER)
    private VehicleModel vehicleModel;

    //CONSTRUCTORS
    public Vehicle(){}
    public Vehicle(Date year, String licensePlate, String vin, String color, VehicleModel vehicleModel) {
        this.setYearProduced(year);
        this.setLicensePlate(licensePlate);
        this.setVin(vin);
        this.setColor(color);
        this.setVehicleModel(vehicleModel);

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

    public Date getYearProduced() {
        return YearProduced;
    }

    public void setYearProduced(Date yearProduced) {
        YearProduced = yearProduced;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}