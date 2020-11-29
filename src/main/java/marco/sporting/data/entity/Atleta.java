package marco.sporting.data.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ATLETA")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    @Basic(optional = false)
    private String nome;

    @Column(name = "COGNOME")
    @Basic(optional = false)
    private String cognome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return Objects.equals(id, atleta.id) &&
                Objects.equals(nome, atleta.nome) &&
                Objects.equals(cognome, atleta.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome);
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
