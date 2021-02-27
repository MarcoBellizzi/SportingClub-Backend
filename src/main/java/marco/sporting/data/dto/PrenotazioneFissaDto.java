package marco.sporting.data.dto;

import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.FasciaOraria;
import marco.sporting.data.entity.Prenotazione;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrenotazioneFissaDto implements Serializable {

    private Long id;

    private int giorno;

    private FasciaOraria fasciaOraria;

    private Campo campo;

    private int durata;

    private Atleta prenotazione;

    private List<LocalDate> prenotazioniDisdette = new ArrayList<>();

    private List<Giorno> prenotazioniDisdetteCustom = new ArrayList<>();

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

    public Atleta getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Atleta prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public List<LocalDate> getPrenotazioniDisdette() {
        return prenotazioniDisdette;
    }

    public void setPrenotazioniDisdette(List<LocalDate> prenotazioniDisdette) {
        this.prenotazioniDisdette = prenotazioniDisdette;
    }

    public List<Giorno> getPrenotazioniDisdetteCustom() {
        return prenotazioniDisdetteCustom;
    }

    public void setPrenotazioniDisdetteCustom(List<Giorno> prenotazioniDisdetteCustom) {
        this.prenotazioniDisdetteCustom = prenotazioniDisdetteCustom;
    }

    @Override
    public String toString() {
        return "PrenotazioneFissaDto{" +
                "id=" + id +
                ", giorno=" + giorno +
                ", fasciaOraria=" + fasciaOraria +
                ", campo=" + campo +
                ", durata=" + durata +
                ", prenotazione=" + prenotazione +
                ", prenotazioniDisdette=" + prenotazioniDisdette +
                ", prenotazioniDisdetteCustom=" + prenotazioniDisdetteCustom +
                '}';
    }
}
