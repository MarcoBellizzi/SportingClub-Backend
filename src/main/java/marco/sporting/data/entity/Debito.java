package marco.sporting.data.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DEBITO")
public class Debito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ATLETA", referencedColumnName = "ID")
    private Atleta atleta;

    @Column(name = "IMPORTO")
    private float importo;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

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

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debito debito = (Debito) o;
        return importo == debito.importo && Objects.equals(id, debito.id) && Objects.equals(atleta, debito.atleta) && Objects.equals(descrizione, debito.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, atleta, importo, descrizione);
    }
}
