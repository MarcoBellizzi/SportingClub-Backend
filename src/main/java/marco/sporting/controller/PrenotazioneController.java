package marco.sporting.controller;

import marco.sporting.data.dto.PrenotazioneDto;
import marco.sporting.data.service.impl.PrenotazioneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneServiceImpl prenotazioneService;

    @GetMapping("/prenotazioni")
    public ResponseEntity<List<PrenotazioneDto>> all() {
        return ResponseEntity.ok(prenotazioneService.getPrenotazioni());
    }

}
