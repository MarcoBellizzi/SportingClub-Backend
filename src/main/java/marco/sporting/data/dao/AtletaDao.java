package marco.sporting.data.dao;

import marco.sporting.data.entity.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtletaDao extends JpaRepository<Atleta, Long> {
}
