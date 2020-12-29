package marco.sporting.data.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PRENOTAZIONE")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ATLETA", referencedColumnName = "ID")
    private Atleta atleta;

    @ManyToOne
    @JoinColumn(name = "CAMPO", referencedColumnName = "ID")
    private Campo campo;

    @ManyToOne
    @JoinColumn(name = "FASCIA_ORARIA", referencedColumnName = "ID")
    private FasciaOraria fasciaOraria;

    @Column(name = "GIORNO")
    private LocalDate giorno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public LocalDate getGiorno() {
        return giorno;
    }

    public void setGiorno(LocalDate giorno) {
        this.giorno = giorno;
    }

    public FasciaOraria getFasciaOraria() {
        return fasciaOraria;
    }

    public void setFasciaOraria(FasciaOraria fasciaOraria) {
        this.fasciaOraria = fasciaOraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(id, that.id) && Objects.equals(atleta, that.atleta) && Objects.equals(campo, that.campo) && Objects.equals(giorno, that.giorno) && Objects.equals(fasciaOraria, that.fasciaOraria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, atleta, campo, giorno, fasciaOraria);
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", atleta=" + atleta +
                ", campo=" + campo +
                ", giorno=" + giorno +
                ", fasciaOraria=" + fasciaOraria +
                '}';
    }
}
