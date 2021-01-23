package marco.sporting.data.dto;

import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.FasciaOraria;
import marco.sporting.data.entity.Prenotazione;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrenotazioneDto implements Serializable {

    private Long id;

    private AtletaDto atleta;

    private CampoDto campo;

    private LocalDate giorno;

    private List<FasciaOraria> fasceOrarie = new ArrayList<>();

    private boolean libera;

    private String nome;

    private String tipo;

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

    public List<FasciaOraria> getFasceOrarie() {
        return fasceOrarie;
    }

    public void setFasceOrarie(List<FasciaOraria> fasceOrarie) {
        this.fasceOrarie = fasceOrarie;
    }

    public boolean isLibera() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "PrenotazioneDto{" +
                "id=" + id +
                ", atleta=" + atleta +
                ", campo=" + campo +
                ", giorno=" + giorno +
                ", fasceOrarie=" + fasceOrarie +
                ", libera=" + libera +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
