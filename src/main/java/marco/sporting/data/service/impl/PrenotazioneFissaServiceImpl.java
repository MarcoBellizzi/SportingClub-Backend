package marco.sporting.data.service.impl;

import marco.sporting.data.dao.PrenotazioneFissaDao;
import marco.sporting.data.dto.PrenotazioneFissaDto;
import marco.sporting.data.entity.PrenotazioneFissa;
import marco.sporting.data.service.PrenotazioneFissaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrenotazioneFissaServiceImpl implements PrenotazioneFissaService {

    @Autowired
    PrenotazioneFissaDao prenotazioneFissaDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PrenotazioneFissaDto addPrenotazioneFissa(PrenotazioneFissaDto prenotazioneFissaDto) {
        PrenotazioneFissa prenotazioneFissa = modelMapper.map(prenotazioneFissaDto, PrenotazioneFissa.class);
        return modelMapper.map(prenotazioneFissaDao.save(prenotazioneFissa), PrenotazioneFissaDto.class);
    }

    @Override
    public List<PrenotazioneFissaDto> getPrenotazioneFisse() {
        List<PrenotazioneFissaDto> prenotazioni = new ArrayList<>();
        for (PrenotazioneFissa prenotazione : prenotazioneFissaDao.findAll()) {
            prenotazioni.add(modelMapper.map(prenotazione, PrenotazioneFissaDto.class));
        }
        return prenotazioni;
    }

    @Override
    public void deletePrenotazioneFissa(Long id) {
        prenotazioneFissaDao.delete(prenotazioneFissaDao.findById(id).orElseThrow());
    }
}
