package marco.sporting.data.service;

import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.DebitoDto;

import java.util.List;

public interface DebitoService {
    DebitoDto save(DebitoDto debitoDto);
    List<DebitoDto> getDebiti();
    List<DebitoDto> getDebiti(Long atletaId);
}
