package marco.sporting.data.service.impl;

import marco.sporting.data.dao.AtletaDao;
import marco.sporting.data.dao.PrenotazioneFissaDao;
import marco.sporting.data.dto.Giorno;
import marco.sporting.data.dto.PrenotazioneFissaDto;
import marco.sporting.data.entity.PrenotazioneFissa;
import marco.sporting.data.service.PrenotazioneFissaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrenotazioneFissaServiceImpl implements PrenotazioneFissaService {

    @Autowired
    PrenotazioneFissaDao prenotazioneFissaDao;

    @Autowired
    AtletaDao atletaDao;

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
            PrenotazioneFissaDto prenotazioneFissaDto = modelMapper.map(prenotazione, PrenotazioneFissaDto.class);
            for (LocalDate date : prenotazione.getPrenotazioniDisdette()) {
                prenotazioneFissaDto.getPrenotazioniDisdetteCustom().add(new Giorno(date.getDayOfMonth(), date.getMonthValue(), date.getYear()));
            }
            prenotazioni.add(prenotazioneFissaDto);
        }
        return prenotazioni;
    }

    @Override
    public List<PrenotazioneFissaDto> getPrenotazioniFisse(Long atletaId) {
        List<PrenotazioneFissaDto> prenotazioni = new ArrayList<>();
        for (PrenotazioneFissa prenotazioneFissa : prenotazioneFissaDao.findAllByPrenotazione(
                atletaDao.findById(atletaId).orElseThrow())) {
            prenotazioni.add(modelMapper.map(prenotazioneFissa, PrenotazioneFissaDto.class));
        }
        return prenotazioni;
    }

    @Override
    public void deletePrenotazioneFissa(Long id) {
        prenotazioneFissaDao.delete(prenotazioneFissaDao.findById(id).orElseThrow());
    }

    @Override
    public PrenotazioneFissaDto aggiungiPrenotazioneDisdetta(Long id, LocalDate giorno) {
        PrenotazioneFissa prenotazioneFissa = prenotazioneFissaDao.findById(id).orElseThrow(
                () -> new RuntimeException("Prenotazione fissa non trovata"));

        prenotazioneFissa.getPrenotazioniDisdette().add(giorno);

        prenotazioneFissaDao.save(prenotazioneFissa);

        return modelMapper.map(prenotazioneFissa, PrenotazioneFissaDto.class);
    }
}
