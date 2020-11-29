package marco.sporting.data.service;

import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.dto.PrenotazioneDto;
import java.util.List;

public interface PrenotazioneService {
    PrenotazioneDto addPrenotazione(AtletaDto atleta, CampoDto campo) throws Exception;
    List<PrenotazioneDto> getPrenotazioni();
}
