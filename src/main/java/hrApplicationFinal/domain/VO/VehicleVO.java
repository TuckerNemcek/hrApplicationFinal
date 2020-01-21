package hrApplicationFinal.domain.VO;

import hrApplicationFinal.domain.VehicleModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class VehicleVO {

    private Integer id;


    private String licensePlate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date YearProduced;
    private String Vin;
    private String Color;
    private VehicleModel vehicleModel;

    public VehicleVO () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getYearProduced() {
        return YearProduced;
    }

    public void setYearProduced(Date yearProduced) {
        YearProduced = yearProduced;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
