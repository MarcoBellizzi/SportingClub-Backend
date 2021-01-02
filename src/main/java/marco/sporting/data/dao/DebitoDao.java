package marco.sporting.data.dao;

import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Debito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitoDao extends JpaRepository<Debito, Long> {
    List<Debito> findAllByAtleta(Atleta atleta);
}
