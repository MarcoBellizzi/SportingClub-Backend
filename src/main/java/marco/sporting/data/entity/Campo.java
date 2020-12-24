package marco.sporting.data.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAMPO")
public class Campo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    @Basic(optional = false)
    private String nome;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campo campo = (Campo) o;
        return Objects.equals(id, campo.id) &&
                Objects.equals(nome, campo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Campo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
