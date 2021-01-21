package marco.sporting.data.dao;

import marco.sporting.data.entity.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtletaDao extends JpaRepository<Atleta, Long> {
    Optional<Atleta> findByEmail(String email);
    Optional<Atleta> findByNomeAndCognome(String nome, String cognome);
    List<Atleta> findAllByAdmin(boolean admin);
}
