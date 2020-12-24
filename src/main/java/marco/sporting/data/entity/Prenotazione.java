package marco.sporting.data.entity;

import javax.persistence.*;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(atleta, that.atleta) &&
                Objects.equals(campo, that.campo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, atleta, campo);
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", atleta=" + atleta +
                ", campo=" + campo +
                '}';
    }
}
