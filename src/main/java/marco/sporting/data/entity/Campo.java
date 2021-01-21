package marco.sporting.data.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAMPO")
public class Campo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "NOME")
    @Basic(optional = false)
    protected String nome;

    @Column(name = "DESCRIZIONE")
    protected String descrizione;

    @Column(name = "PHOTO")
    protected String photo;

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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campo campo = (Campo) o;
        return Objects.equals(id, campo.id) && Objects.equals(nome, campo.nome) && Objects.equals(descrizione, campo.descrizione) && Objects.equals(photo, campo.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descrizione, photo);
    }

    @Override
    public String toString() {
        return "Campo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
