package pl.project.carental.domain;

import javax.persistence.*;

@Entity
@Table(name = "rented_car")
public class RentedCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_id")
    private long userId;

    @Column(name = "car_id")
    private long carId;

    @Column(name = "car_brand")
    private String carBrand;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "accessKey")
    private String accessKey;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "price")
    private int price;

    @Column(name = "isAvail")
    private boolean isAvail;

    public RentedCar(long userId, long carId, String carBrand, String carModel, String carType, String accessKey, String date, String time, int price) {
        this.userId = userId;
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carType = carType;
        this.accessKey = accessKey;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public RentedCar() {
    }

    public boolean isAvail() {
        return isAvail;
    }

    public void setAvail(boolean avail) {
        isAvail = avail;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RentedCar{" +
                "userId=" + userId +
                ", carId=" + carId +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carType='" + carType + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                '}';
    }
}
