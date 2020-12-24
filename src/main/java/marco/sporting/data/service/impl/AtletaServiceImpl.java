package marco.sporting.data.service.impl;

import marco.sporting.data.dao.AtletaDao;
import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.entity.Atleta;
import marco.sporting.data.service.AtletaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtletaServiceImpl implements AtletaService {

    @Autowired
    private AtletaDao atletaDao;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public AtletaDto addAtleta(AtletaDto atletaDto) {
        Atleta atleta = modelMapper.map(atletaDto, Atleta.class);
        Atleta saved = atletaDao.save(atleta);
        return modelMapper.map(saved, AtletaDto.class);
    }

    @Override
    public List<AtletaDto> getAtleti() {
        List<AtletaDto> atletiDto = new ArrayList<AtletaDto>();
        for(Atleta atleta : atletaDao.findAll()) {
            AtletaDto atletaDto = modelMapper.map(atleta, AtletaDto.class);
            atletiDto.add(atletaDto);
        }
        return atletiDto;
    }

    @Override
    public AtletaDto getAtleta(Long id){
        return modelMapper.map(atletaDao.findById(id).orElseThrow(() -> new RuntimeException("atleta non trovato")), AtletaDto.class);
    }
}
