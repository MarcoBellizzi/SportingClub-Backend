package marco.sporting.data.service;

import marco.sporting.data.dto.AtletaDto;
import java.util.List;

public interface AtletaService {
    AtletaDto addAtleta(AtletaDto atletaDto);
    AtletaDto getAtleta(Long id) throws Exception;
    List<AtletaDto> getAtleti();
}
