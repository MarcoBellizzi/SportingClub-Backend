package marco.sporting.data.dto;

import java.io.Serializable;

public class FasciaOrariaDto implements Serializable {

    private Long id;

    private String inizio;

    private String fine;

    public FasciaOrariaDto() {
    }

    public FasciaOrariaDto(String inizio,String fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

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
    public String toString() {
        return "FasciaOrariaDto{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                '}';
    }
}
