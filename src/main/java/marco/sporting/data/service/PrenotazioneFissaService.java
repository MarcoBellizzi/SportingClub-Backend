package marco.sporting.data.service;

import marco.sporting.data.dto.PrenotazioneFissaDto;
import marco.sporting.data.entity.Atleta;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneFissaService {
    PrenotazioneFissaDto addPrenotazioneFissa(PrenotazioneFissaDto prenotazioneFissaDto);
    List<PrenotazioneFissaDto> getPrenotazioneFisse();
    List<PrenotazioneFissaDto> getPrenotazioniFisse(Long atletaId);
    void deletePrenotazioneFissa(Long id);
    PrenotazioneFissaDto aggiungiPrenotazioneDisdetta(Long id, LocalDate giorno);
}
