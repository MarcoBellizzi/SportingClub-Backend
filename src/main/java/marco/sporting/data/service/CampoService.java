package marco.sporting.data.service;

import marco.sporting.data.dto.CampoDto;
import java.util.List;

public interface CampoService {
    CampoDto addCampo(CampoDto campoDto);
    CampoDto getCampo(Long id) throws Exception;
    List<CampoDto> getCampi();
}
