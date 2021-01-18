package marco.sporting.data.service;

import marco.sporting.data.dto.AtletaDto;
import java.util.List;

public interface AtletaService {
    AtletaDto logIn(String email, String password);
    AtletaDto addAtleta(AtletaDto atletaDto);
    AtletaDto getAtleta(Long id);
    AtletaDto getAtleta(String nome, String cognome);
    List<AtletaDto> getAtleti();
    AtletaDto addAdmin(AtletaDto atletaDto);
}
