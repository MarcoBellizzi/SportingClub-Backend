package marco.sporting.data.dto;

import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.FasciaOraria;

import java.io.Serializable;

public class PrenotazioneFissaDto implements Serializable {

    private Long id;

    private int giorno;

    private FasciaOraria fasciaOraria;

    private Campo campo;

    private int durata;

    private String prenotazione;

    public PrenotazioneFissaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public FasciaOraria getFasciaOraria() {
        return fasciaOraria;
    }

    public void setFasciaOraria(FasciaOraria fasciaOraria) {
        this.fasciaOraria = fasciaOraria;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(String prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    @Override
    public String toString() {
        return "PrenotazioneFissaDto{" +
                "id=" + id +
                ", giorno=" + giorno +
                ", fasciaOraria=" + fasciaOraria +
                ", campo=" + campo +
                ", durata=" + durata +
                ", prenotazione='" + prenotazione + '\'' +
                '}';
    }
}
