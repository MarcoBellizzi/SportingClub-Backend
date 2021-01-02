package marco.sporting.data.service.impl;

import marco.sporting.data.dao.AtletaDao;
import marco.sporting.data.dao.DebitoDao;
import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.DebitoDto;
import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Debito;
import marco.sporting.data.service.DebitoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DebitoServiceImpl implements DebitoService {

    @Autowired
    DebitoDao debitoDao;

    @Autowired
    AtletaDao atletaDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public DebitoDto save(DebitoDto debitoDto) {
        Debito debito = debitoDao.save(modelMapper.map(debitoDto, Debito.class));
        return modelMapper.map(debito, DebitoDto.class);
    }

    @Override
    public List<DebitoDto> getDebiti() {
        List<DebitoDto> debiti = new ArrayList<>();
        for(Debito debito : debitoDao.findAll()) {
            debiti.add(modelMapper.map(debito, DebitoDto.class));
        }
        return debiti;
    }

    @Override
    public List<DebitoDto> getDebiti(Long atletaId) {
        Atleta atleta = atletaDao.findById(atletaId).orElseThrow(
                () -> new RuntimeException("atleta " + atletaId + " non trovato"));
        List<DebitoDto> debiti = new ArrayList<>();
        for(Debito debito : debitoDao.findAllByAtleta(atleta)) {
            debiti.add(modelMapper.map(debito, DebitoDto.class));
        }
        return debiti;
    }

    @Override
    public void saldaDebito(Long debitoId) {
        debitoDao.delete(debitoDao.findById(debitoId).orElseThrow(
                () -> new RuntimeException("debito " + debitoId + " non trovato")));
    }
}
