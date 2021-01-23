package marco.sporting.data.dao;

import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.FasciaOraria;
import marco.sporting.data.entity.Prenotazione;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PrenotazioneDao extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findAllByGiorno(LocalDate giorno);
    List<Prenotazione> findAllByAtletaAndGiornoAfter(Atleta atleta, LocalDate giorno);
}
