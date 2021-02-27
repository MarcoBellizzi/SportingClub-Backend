package marco.sporting.data.service.impl;

import marco.sporting.data.dao.*;
import marco.sporting.data.dto.PrenotazioneDto;
import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.Prenotazione;
import marco.sporting.data.entity.PrenotazioneFissa;
import marco.sporting.data.service.PrenotazioneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
    private FasciaOrariaDao fasciaOrariaDao;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public PrenotazioneDto addPrenotazione(PrenotazioneDto prenotazioneDto) {
        Atleta atleta = atletaDao.findById(prenotazioneDto.getAtleta().getId()).orElseThrow(
                () -> new RuntimeException("atleta non trovato"));
        Campo campo = campoDao.findById(prenotazioneDto.getCampo().getId()).orElseThrow(
                () -> new RuntimeException("campo non trovato"));

        Prenotazione prenotazione = modelMapper.map(prenotazioneDto, Prenotazione.class);
        return modelMapper.map(prenotazioneDao.save(prenotazione), PrenotazioneDto.class);
    }

    @Override
    public List<PrenotazioneDto> getPrenotazioni() {
        List<PrenotazioneDto> prenotazioniDto = new ArrayList<>();
        for(Prenotazione prenotazione : prenotazioneDao.findAll()) {
            prenotazioniDto.add(modelMapper.map(prenotazione, PrenotazioneDto.class));
        }
        return prenotazioniDto;
    }

    @Override
    public List<PrenotazioneDto> getPrenotazioni(LocalDate giorno) {
        List<PrenotazioneDto> prenotazioniDto = new ArrayList<>();
        for(Prenotazione prenotazione : prenotazioneDao.findAllByGiorno(giorno)) {
            prenotazioniDto.add(modelMapper.map(prenotazione, PrenotazioneDto.class));
        }
        return prenotazioniDto;
    }

    @Override
    public void annullaPrenotazione(Long prenotazioneId) {
        prenotazioneDao.delete(prenotazioneDao.findById(prenotazioneId).orElseThrow(
                () -> new RuntimeException("prenotazione non trovata")));
    }

    @Override
    public List<PrenotazioneDto> getPrenotazioniAfter(Long atletaId, LocalDate giorno) {
        Atleta atleta = atletaDao.findById(atletaId).orElseThrow(
                () -> new RuntimeException("atleta " + atletaId + " non trovato"));
        List<PrenotazioneDto> prenotazioni = new ArrayList<>();
        for(Prenotazione prenotazione : prenotazioneDao.findAllByAtletaAndGiornoAfter(atleta, giorno)) {
            if(!prenotazione.getLibera()) {
                prenotazioni.add(modelMapper.map(prenotazione, PrenotazioneDto.class));
            }
        }
        return prenotazioni;
    }

}
