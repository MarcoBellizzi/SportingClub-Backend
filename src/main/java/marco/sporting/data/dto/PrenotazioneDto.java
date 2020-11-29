package marco.sporting.data.dto;

import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;

import java.io.Serializable;

public class PrenotazioneDto implements Serializable {

    private Long id;

    private Atleta atleta;

    private Campo campo;

    public PrenotazioneDto() {
    }

    public PrenotazioneDto(Long id, Atleta atleta, Campo campo) {
        this.id = id;
        this.atleta = atleta;
        this.campo = campo;
    }

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
    public String toString() {
        return "PrenotazioneDto{" +
                "id=" + id +
                ", atleta=" + atleta +
                ", campo=" + campo +
                '}';
    }
}
