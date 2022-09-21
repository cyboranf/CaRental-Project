package pl.project.carental.domain;

import javax.persistence.*;

@Entity
@Table(name = "access_key")
public class AccessKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "car_package", nullable = false)
    private String carPackage;

    @Column(name = "hours", nullable = false)
    private Integer hours;

    @OneToOne
    private User user;

    public AccessKey(Long id, String carPackage, Integer hours, User user) {
        this.id = id;
        this.carPackage = carPackage;
        this.hours = hours;
        this.user = user;
    }

    public AccessKey() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarPackage() {
        return carPackage;
    }

    public void setCarPackage(String carPackage) {
        this.carPackage = carPackage;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AccessKey{" +
                "id=" + id +
                ", carPackage='" + carPackage + '\'' +
                ", hours=" + hours +
                ", user=" + user +
                '}';
    }
}
