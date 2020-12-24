package marco.sporting.data.dao;

import marco.sporting.data.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneDao extends JpaRepository<Prenotazione, Long> {
}
