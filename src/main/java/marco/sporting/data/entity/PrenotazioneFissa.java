package marco.sporting.data.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRENOTAZIONE_FISSA")
public class PrenotazioneFissa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "GIORNO")
    private int giorno;

    @ManyToOne
    @JoinColumn(name = "FASCIA_ORARIA", referencedColumnName = "ID")
    private FasciaOraria fasciaOraria;

    @Column(name = "DURATA")
    private int durata;

    @Column(name = "PRENOTAZIONE")
    private String prenotazione;

    @ManyToOne
    @JoinColumn(name = "CAMPO", referencedColumnName = "ID")
    private Campo campo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public FasciaOraria getFasciaOraria() {
        return fasciaOraria;
    }

    public void setFasciaOraria(FasciaOraria fasciaOraria) {
        this.fasciaOraria = fasciaOraria;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(String prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrenotazioneFissa that = (PrenotazioneFissa) o;
        return giorno == that.giorno && durata == that.durata && Objects.equals(id, that.id) && Objects.equals(fasciaOraria, that.fasciaOraria) && Objects.equals(prenotazione, that.prenotazione) && Objects.equals(campo, that.campo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, giorno, fasciaOraria, durata, prenotazione, campo);
    }

    @Override
    public String toString() {
        return "PrenotazioneFissa{" +
                "id=" + id +
                ", giorno=" + giorno +
                ", fasciaOraria=" + fasciaOraria +
                ", durata=" + durata +
                ", prenotazione='" + prenotazione + '\'' +
                ", campo=" + campo +
                '}';
    }
}
