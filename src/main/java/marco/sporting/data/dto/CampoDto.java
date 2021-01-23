package marco.sporting.data.dto;

import marco.sporting.data.entity.Campo;

import java.io.Serializable;
import java.util.Objects;

public class CampoDto implements Serializable {

    private Long id;

    private String nome;

    public CampoDto() {
    }

    public CampoDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

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
        CampoDto campoDto = (CampoDto) o;
        return Objects.equals(id, campoDto.id) && Objects.equals(nome, campoDto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "CampoDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
