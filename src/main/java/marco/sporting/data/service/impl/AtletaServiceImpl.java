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

    @Override
    public AtletaDto logIn(String username, String password) {
        Atleta atleta = atletaDao.findByUsername(username).orElseThrow(() -> new RuntimeException("atleta " + username + " non trovato"));
        if(!atleta.getPassword().equals(password)) {
            throw new RuntimeException("password sbagliata");
        }
        return modelMapper.map(atleta, AtletaDto.class);
    }

    @Transactional
    @Override
    public AtletaDto addAtleta(AtletaDto atletaDto) {
        Atleta atleta = modelMapper.map(atletaDto, Atleta.class);
        return modelMapper.map(atletaDao.save(atleta), AtletaDto.class);
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
