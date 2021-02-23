package marco.sporting.data.dao;

import marco.sporting.data.entity.PrenotazioneFissa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneFissaDao extends JpaRepository<PrenotazioneFissa, Long> {
}
