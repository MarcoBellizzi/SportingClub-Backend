package marco.sporting.data.dao;

import marco.sporting.data.entity.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtletaDao extends JpaRepository<Atleta, Long> {
    Optional<Atleta> findByUsername(String username);
}
