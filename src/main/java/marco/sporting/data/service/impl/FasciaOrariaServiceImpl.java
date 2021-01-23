package marco.sporting.data.service.impl;

import marco.sporting.data.dao.FasciaOrariaDao;
import marco.sporting.data.dto.FasciaOrariaDto;
import marco.sporting.data.entity.FasciaOraria;
import marco.sporting.data.service.FasciaOrariaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FasciaOrariaServiceImpl implements FasciaOrariaService {

    @Autowired
    FasciaOrariaDao fasciaOrariaDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public FasciaOrariaDto save(FasciaOrariaDto fasciaOrariaDto) {
        FasciaOraria fasciaOraria = fasciaOrariaDao.save(modelMapper.map(fasciaOrariaDto, FasciaOraria.class));
        return modelMapper.map(fasciaOraria, FasciaOrariaDto.class);
    }

    @Override
    public List<FasciaOrariaDto> getFasceOrarie() {
        List<FasciaOrariaDto> fasceOrarie = new ArrayList<>();
        for(FasciaOraria fasciaOraria : fasciaOrariaDao.findAll()) {
            fasceOrarie.add(modelMapper.map(fasciaOraria, FasciaOrariaDto.class));
        }
        return fasceOrarie;
    }

    @Override
    public FasciaOrariaDto getFasciaOraria(Long fasciaId) {
        return modelMapper.map(fasciaOrariaDao.findById(fasciaId).orElseThrow(
                () -> new RuntimeException("fascia oraria non trovata")), FasciaOrariaDto.class);
    }
}
