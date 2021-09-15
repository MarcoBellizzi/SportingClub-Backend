package marco.sporting.data.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(name = "PRENOTAZIONE", referencedColumnName = "ID")
    private Atleta prenotazione;

    @ManyToOne
    @JoinColumn(name = "CAMPO", referencedColumnName = "ID")
    private Campo campo;

    @ElementCollection
    @CollectionTable(name="PROTAZIONI_DISDETTE")
    private List<LocalDate> prenotazioniDisdette = new ArrayList<LocalDate>();

    @Column(name = "DETTAGLI")
    private String dettagli;

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

    public Atleta getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Atleta prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public List<LocalDate> getPrenotazioniDisdette() {
        return prenotazioniDisdette;
    }

    public void setPrenotazioniDisdette(List<LocalDate> prenotazioniDisdette) {
        this.prenotazioniDisdette = prenotazioniDisdette;
    }

    public String getDettagli() {
        return dettagli;
    }

    public void setDettagli(String dettagli) {
        this.dettagli = dettagli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrenotazioneFissa that = (PrenotazioneFissa) o;
        return giorno == that.giorno && durata == that.durata && Objects.equals(id, that.id) && Objects.equals(fasciaOraria, that.fasciaOraria) && Objects.equals(prenotazione, that.prenotazione) && Objects.equals(campo, that.campo) && Objects.equals(prenotazioniDisdette, that.prenotazioniDisdette) && Objects.equals(dettagli, that.dettagli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, giorno, fasciaOraria, durata, prenotazione, campo, prenotazioniDisdette, dettagli);
    }

    @Override
    public String toString() {
        return "PrenotazioneFissa{" +
                "id=" + id +
                ", giorno=" + giorno +
                ", fasciaOraria=" + fasciaOraria +
                ", durata=" + durata +
                ", prenotazione=" + prenotazione +
                ", campo=" + campo +
                ", prenotazioniDisdette=" + prenotazioniDisdette +
                ", dettagli='" + dettagli + '\'' +
                '}';
    }
}
