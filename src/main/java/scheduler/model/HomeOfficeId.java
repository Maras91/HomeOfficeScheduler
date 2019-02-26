package scheduler.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class HomeOfficeId  implements Serializable {
    protected String dasId;
    protected LocalDate day;

    public HomeOfficeId() {
    }

    public HomeOfficeId(String dasId, LocalDate day) {
        this.dasId = dasId;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HomeOfficeId)) return false;
        HomeOfficeId that = (HomeOfficeId) o;
        return Objects.equals(dasId, that.dasId) &&
                Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dasId, day);
    }
}
