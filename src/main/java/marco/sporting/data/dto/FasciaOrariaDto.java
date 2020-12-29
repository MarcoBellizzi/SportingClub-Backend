package marco.sporting.data.dto;

import java.io.Serializable;

public class FasciaOrariaDto implements Serializable {

    private Long id;

    private int inizio;

    private int fine;

    public FasciaOrariaDto() {
    }

    public FasciaOrariaDto(int inizio, int fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

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
    public String toString() {
        return "FasciaOrariaDto{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                '}';
    }
}
