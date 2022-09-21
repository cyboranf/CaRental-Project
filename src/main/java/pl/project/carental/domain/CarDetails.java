package pl.project.carental.domain;

import javax.persistence.*;

@Entity
@Table(name="car_details")
public class CarDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "package_name")
    private String packageName;


    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "power")
    private int power;

    @Column(name = "price_per_hour")
    private Double price_per_hour;

    @Column(name = "price_per_day")
    private Double price_per_day;

    public CarDetails(long id, String packageName, String fuelType, int power, Double price_per_hour, Double price_per_day) {
        this.id = id;
        this.packageName = packageName;
        this.fuelType = fuelType;
        this.power = power;
        this.price_per_hour = price_per_hour;
        this.price_per_day = price_per_day;
    }

    public CarDetails() {
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Double getPrice_per_hour() {
        return price_per_hour;
    }

    public void setPrice_per_hour(Double price_per_hour) {
        this.price_per_hour = price_per_hour;
    }

    public Double getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(Double price_per_day) {
        this.price_per_day = price_per_day;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "id=" + id +
                ", packageName='" + packageName + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", power=" + power +
                ", price_per_hour=" + price_per_hour +
                ", price_per_day=" + price_per_day +
                '}';
    }
}
