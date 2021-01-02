package marco.sporting.data.service;

import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.dto.FasciaOrariaDto;
import marco.sporting.data.dto.PrenotazioneDto;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneService {
    PrenotazioneDto addPrenotazione(PrenotazioneDto prenotazioneDto);
    List<PrenotazioneDto> getPrenotazioni();
    List<PrenotazioneDto> getPrenotazioni(LocalDate giorno);
    void annullaPrenotazione(Long fasciaOrariaId, Long campoId);
    List<PrenotazioneDto> getPrenotazioniAfter(Long atletaId, LocalDate giorno);
}
