package marco.sporting.controller;

import marco.sporting.data.dto.PrenotazioneDto;
import marco.sporting.data.service.impl.PrenotazioneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sporting")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneServiceImpl prenotazioneService;

    @GetMapping("/prenotazioni")
    public ResponseEntity<List<PrenotazioneDto>> getPrenotazioni() {
        return ResponseEntity.ok(prenotazioneService.getPrenotazioni());
    }

    @PostMapping("prenotazioni/add")
    public ResponseEntity<PrenotazioneDto> addPrenotazione(@RequestBody PrenotazioneDto prenotazioneDto) {
        return ResponseEntity.ok(prenotazioneService.addPrenotazione(prenotazioneDto));
    }



}
