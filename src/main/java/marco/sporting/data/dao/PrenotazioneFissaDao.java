package marco.sporting.data.dao;

import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.PrenotazioneFissa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneFissaDao extends JpaRepository<PrenotazioneFissa, Long> {
    List<PrenotazioneFissa> findAllByPrenotazione(Atleta atleta);
}
