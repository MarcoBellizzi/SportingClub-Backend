package marco.sporting.controller;

import marco.sporting.data.dto.PrenotazioneDto;
import marco.sporting.data.service.impl.PrenotazioneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/sporting")
@CrossOrigin(origins = "http://localhost:4200")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneServiceImpl prenotazioneService;

    @GetMapping("/prenotazioni")
    public ResponseEntity<List<PrenotazioneDto>> getPrenotazioni() {
        return ResponseEntity.ok(prenotazioneService.getPrenotazioni());
    }

    @PutMapping("/prenotazioni/giorno")
    public ResponseEntity<List<PrenotazioneDto>> getPrenotazioni(@RequestBody LocalDate giorno) {
        return ResponseEntity.ok(prenotazioneService.getPrenotazioni(giorno));
    }

    @PostMapping("/prenotazione/add")
    public ResponseEntity<PrenotazioneDto> addPrenotazione(@RequestBody PrenotazioneDto prenotazioneDto) {
        System.out.println(prenotazioneDto);
        return ResponseEntity.ok(prenotazioneService.addPrenotazione(prenotazioneDto));
    }

    @DeleteMapping("/prenotazione/annulla")
    public void annullaPrenotazione(@RequestParam(name = "prenotazioneId") Long prenotazioneId) {
        prenotazioneService.annullaPrenotazione(prenotazioneId);
    }

    @PutMapping("/prenotazioni/after")
    public ResponseEntity<List<PrenotazioneDto>> getPrenotazioniAfter(@RequestParam(name = "atletaId") Long atletaId,
                                                                      @RequestBody LocalDate giorno) {
        return ResponseEntity.ok(prenotazioneService.getPrenotazioniAfter(atletaId, giorno));
    }

}
