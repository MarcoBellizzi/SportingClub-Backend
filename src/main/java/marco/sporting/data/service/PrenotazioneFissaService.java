package marco.sporting.data.service;

import marco.sporting.data.dto.PrenotazioneFissaDto;

import java.util.List;

public interface PrenotazioneFissaService {
    PrenotazioneFissaDto addPrenotazioneFissa(PrenotazioneFissaDto prenotazioneFissaDto);
    List<PrenotazioneFissaDto> getPrenotazioneFisse();
    void deletePrenotazioneFissa(Long id);
}
