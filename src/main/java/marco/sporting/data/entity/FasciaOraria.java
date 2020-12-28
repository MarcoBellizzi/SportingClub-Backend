package marco.sporting.data.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FASCIA_ORARIA")
public class FasciaOraria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "INIZIO")
    private int inizio;

    @Column(name = "FINE")
    private int fine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInizio() {
        return inizio;
    }

    public void setInizio(int inizio) {
        this.inizio = inizio;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FasciaOraria that = (FasciaOraria) o;
        return inizio == that.inizio && fine == that.fine && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inizio, fine);
    }
}
