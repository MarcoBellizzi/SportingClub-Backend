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
    public AtletaDto logIn(String email, String password) {
        Atleta atleta = atletaDao.findByEmail(email).orElseThrow(
                () -> new RuntimeException("atleta " + email +" non trovato"));
        if(!atleta.getPassword().equals(password)) {
            throw new RuntimeException("password sbagliata");
        }
        return modelMapper.map(atleta, AtletaDto.class);
    }

    @Transactional
    @Override
    public AtletaDto addAtleta(AtletaDto atletaDto) {
        Atleta atleta = modelMapper.map(atletaDto, Atleta.class);
        atleta.setUsername(atleta.getNome() + " " + atleta.getCognome());
        atleta.setAdmin(false);
        return modelMapper.map(atletaDao.save(atleta), AtletaDto.class);
    }

    @Override
    public AtletaDto addAdmin(AtletaDto atletaDto) {
        Atleta atleta = modelMapper.map(atletaDto, Atleta.class);
        atleta.setUsername(atleta.getNome() + " " + atleta.getCognome());
        atleta.setAdmin(true);
        return modelMapper.map(atletaDao.save(atleta), AtletaDto.class);
    }

    @Override
    public List<AtletaDto> getAtleti() {
        List<AtletaDto> atletiDto = new ArrayList<>();
        for(Atleta atleta : atletaDao.findAll()) {
            atletiDto.add(modelMapper.map(atleta, AtletaDto.class));
        }
        return atletiDto;
    }

    @Override
    public AtletaDto getAtleta(Long id){
        return modelMapper.map(atletaDao.findById(id).orElseThrow(
                () -> new RuntimeException("atleta non trovato")), AtletaDto.class);
    }

    @Override
    public AtletaDto getAtleta(String nome, String cognome) {
        return modelMapper.map(atletaDao.findByNomeAndCognome(nome, cognome).orElseThrow(
                () -> new RuntimeException("atleta " + nome + " " + cognome + " non trovato")), AtletaDto.class);
    }

    @Override
    public List<AtletaDto> getAdmin() {
        List<AtletaDto> admins = new ArrayList<>();
        for(Atleta atleta : atletaDao.findAllByAdmin(true)) {
            admins.add(modelMapper.map(atleta, AtletaDto.class));
        }
        return admins;
    }

    @Override
    public List<AtletaDto> getNotAdmin() {
        List<AtletaDto> admins = new ArrayList<>();
        for(Atleta atleta : atletaDao.findAllByAdmin(false)) {
            admins.add(modelMapper.map(atleta, AtletaDto.class));
        }
        return admins;
    }

    @Override
    public AtletaDto update(AtletaDto atletaDto) {
        Atleta atleta = modelMapper.map(atletaDto, Atleta.class);
        return modelMapper.map(atletaDao.save(atleta), AtletaDto.class);
    }
}
