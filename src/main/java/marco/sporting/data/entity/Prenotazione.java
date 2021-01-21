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

    @Column(name = "LIBERA")
    private boolean libera;

    @Column(name = "NOME")
    private String nome;

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

    public boolean isLibera() {
        return libera;
    }

    // sicurezza
    public boolean getLibera() {
        return libera;
    }

    public void setLibera(boolean libera) {
        this.libera = libera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return libera == that.libera && Objects.equals(id, that.id) && Objects.equals(atleta, that.atleta) && Objects.equals(campo, that.campo) && Objects.equals(fasciaOraria, that.fasciaOraria) && Objects.equals(giorno, that.giorno) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, atleta, campo, fasciaOraria, giorno, libera, nome);
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", atleta=" + atleta +
                ", campo=" + campo +
                ", fasciaOraria=" + fasciaOraria +
                ", giorno=" + giorno +
                ", libera=" + libera +
                ", nome='" + nome + '\'' +
                '}';
    }
}
