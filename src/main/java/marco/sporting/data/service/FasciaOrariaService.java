package marco.sporting.data.service;

import marco.sporting.data.dto.FasciaOrariaDto;

import java.util.List;

public interface FasciaOrariaService {
    FasciaOrariaDto save(FasciaOrariaDto fasciaOrariaDto);
    List<FasciaOrariaDto> getFasceOrarie();
}
