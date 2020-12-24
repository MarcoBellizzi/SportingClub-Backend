package marco.sporting.data.service.impl;

import marco.sporting.data.dao.AtletaDao;
import marco.sporting.data.dao.CampoDao;
import marco.sporting.data.dao.PrenotazioneDao;
import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.dto.PrenotazioneDto;
import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.Prenotazione;
import marco.sporting.data.service.PrenotazioneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    @Autowired
    private PrenotazioneDao prenotazioneDao;

    @Autowired
    private AtletaDao atletaDao;

    @Autowired
    private CampoDao campoDao;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public PrenotazioneDto addPrenotazione(PrenotazioneDto prenotazioneDto) {
        Atleta atleta = atletaDao.findById(prenotazioneDto.getAtleta().getId()).orElseThrow(() -> new RuntimeException("atleta non trovato"));
        Campo campo = campoDao.findById(prenotazioneDto.getCampo().getId()).orElseThrow(() -> new RuntimeException("campo non trovato"));

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setAtleta(atleta);
        prenotazione.setCampo(campo);
        return modelMapper.map(prenotazioneDao.save(prenotazione), PrenotazioneDto.class);
    }

    @Override
    public List<PrenotazioneDto> getPrenotazioni() {
        List<PrenotazioneDto> prenotazioniDto = new ArrayList<PrenotazioneDto>();
        for(Prenotazione prenotazione : prenotazioneDao.findAll()) {
            PrenotazioneDto prenotazioneDto = modelMapper.map(prenotazione, PrenotazioneDto.class);
            prenotazioniDto.add(prenotazioneDto);
        }
        return prenotazioniDto;
    }
}
