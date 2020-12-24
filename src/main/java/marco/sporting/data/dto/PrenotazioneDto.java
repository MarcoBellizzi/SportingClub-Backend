package marco.sporting.data.dto;

import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;

import java.io.Serializable;

public class PrenotazioneDto implements Serializable {

    private Long id;

    private AtletaDto atleta;

    private CampoDto campo;

    public PrenotazioneDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtletaDto getAtleta() {
        return atleta;
    }

    public void setAtleta(AtletaDto atleta) {
        this.atleta = atleta;
    }

    public CampoDto getCampo() {
        return campo;
    }

    public void setCampo(CampoDto campo) {
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
