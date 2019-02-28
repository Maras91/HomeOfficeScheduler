package scheduler.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "HomeOffice")
@IdClass(HomeOfficeId.class)
public class HomeOfficeRecord implements Serializable {

    @Id
    private String dasId;
    @Id
    private LocalDate day;

    private String firstName;

    private String lastName;

    private String isOnHomeOffice;

    public HomeOfficeRecord() {
    }

    public HomeOfficeRecord(String dasId, LocalDate day, String firstName, String lastName, String isOnHomeOffice) {
        this.dasId = dasId;
        this.day = day;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isOnHomeOffice = isOnHomeOffice;
    }

    public String getDasId() {
        return dasId;
    }

    public LocalDate getDay() {
        return day;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIsOnHomeOffice() {
        return isOnHomeOffice;
    }
}
