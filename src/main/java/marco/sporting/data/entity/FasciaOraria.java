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
    private String inizio;

    @Column(name = "FINE")
    private String fine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInizio() {
        return inizio;
    }

    public void setInizio(String inizio) {
        this.inizio = inizio;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
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

    @Override
    public String toString() {
        return "FasciaOraria{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                '}';
    }
}
