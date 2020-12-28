package marco.sporting.data.service.impl;

import marco.sporting.data.dao.CampoDao;
import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.service.CampoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CampoServiceImpl implements CampoService {

    @Autowired
    private CampoDao campoDao;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public CampoDto addCampo(CampoDto campoDto) {
        Campo campo = campoDao.save(modelMapper.map(campoDto, Campo.class));
        return modelMapper.map(campo, CampoDto.class);
    }

    @Override
    public CampoDto getCampo(Long id) {
        return modelMapper.map(campoDao.findById(id).orElseThrow(() -> new RuntimeException("campo non trovato")), CampoDto.class);
    }

    @Override
    public List<CampoDto> getCampi() {
        List<CampoDto> campiDto = new ArrayList<CampoDto>();
        for(Campo campo : campoDao.findAll()) {
            campiDto.add(modelMapper.map(campo, CampoDto.class));
        }
        return campiDto;
    }
}
