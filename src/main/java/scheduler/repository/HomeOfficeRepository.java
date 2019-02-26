package scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduler.model.HomeOfficeId;
import scheduler.model.HomeOfficeRecord;

public interface HomeOfficeRepository extends JpaRepository<HomeOfficeRecord,HomeOfficeId> {
}
