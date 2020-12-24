package marco.sporting.data.service;

import marco.sporting.data.dto.AtletaDto;
import java.util.List;

public interface AtletaService {
    AtletaDto addAtleta(AtletaDto atletaDto);
    AtletaDto getAtleta(Long id);
    List<AtletaDto> getAtleti();
}
