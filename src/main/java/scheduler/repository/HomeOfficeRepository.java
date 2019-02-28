package scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduler.model.HomeOfficeId;
import scheduler.model.HomeOfficeRecord;

import java.time.LocalDate;
import java.util.List;

public interface HomeOfficeRepository extends JpaRepository<HomeOfficeRecord,HomeOfficeId>{

    List<HomeOfficeRecord> findByLastName(String lastName);
    List<HomeOfficeRecord> findByFirstName(String firstName);
    List<HomeOfficeRecord> findByDasId(String dasId);
    List<HomeOfficeRecord> findByDay(LocalDate day);

}
