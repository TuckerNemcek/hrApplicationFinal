package hrApplicationFinal.domain.VO;

public class VehicleVO {

    private Integer id;
    private int YearProduced;
    private String Vin;
    private String Color;

    public VehicleVO () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYearProduced() {
        return YearProduced;
    }

    public void setYearProduced(int yearProduced) {
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
}
