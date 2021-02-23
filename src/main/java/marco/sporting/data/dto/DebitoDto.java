package marco.sporting.data.dto;

import java.io.Serializable;

public class DebitoDto implements Serializable {

    private Long id;

    private AtletaDto atleta;

    private float importo;

    private String descrizione;

    public DebitoDto() {
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

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
