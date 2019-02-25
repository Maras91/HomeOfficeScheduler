package scheduler.model;


import javax.persistence.*;

@Entity
@Table(name = "HomeOffice")
public class HomeOfficeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayNumber;

    private String firstName;

    private String lastName;

    private String isOnHomeOffice;

    public HomeOfficeRecord() {
    }

    public HomeOfficeRecord(Long dayNumber, String firstName, String lastName, String isOnHomeOffice) {
        this.dayNumber = dayNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isOnHomeOffice = isOnHomeOffice;
    }

    public Long getDayNumber() {
        return dayNumber;
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
