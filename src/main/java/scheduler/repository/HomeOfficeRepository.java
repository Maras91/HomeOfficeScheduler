package scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduler.model.HomeOfficeId;
import scheduler.model.HomeOfficeRecord;

import java.util.List;

public interface HomeOfficeRepository extends JpaRepository<HomeOfficeRecord,HomeOfficeId> {
    List<HomeOfficeRecord> findByLastName(String lastName);
}
