package marco.sporting.data.dao;

import marco.sporting.data.entity.FasciaOraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FasciaOrariaDao extends JpaRepository<FasciaOraria, Long> {

}
