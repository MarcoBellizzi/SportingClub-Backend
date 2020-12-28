package marco.sporting.data.dto;

import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.FasciaOraria;

import java.io.Serializable;
import java.time.LocalDate;

public class PrenotazioneDto implements Serializable {

    private Long id;

    private AtletaDto atleta;

    private CampoDto campo;

    private LocalDate giorno;

    private FasciaOraria fasciaOraria;

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


}
