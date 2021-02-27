package marco.sporting.controller;

import marco.sporting.data.dto.PrenotazioneFissaDto;
import marco.sporting.data.service.PrenotazioneFissaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/sporting")
@CrossOrigin(origins = "*")
public class PrenotazioneFissaController {

    @Autowired
    PrenotazioneFissaService prenotazioneFissaService;

    @GetMapping("/prenotazioniFisse")
    public ResponseEntity<List<PrenotazioneFissaDto>> getPrenotazioniFisse() {
        return ResponseEntity.ok(prenotazioneFissaService.getPrenotazioneFisse());
    }

    @GetMapping("/prenotazioniFisseByAtleta")
    public ResponseEntity<List<PrenotazioneFissaDto>> getPrenotazioniFisseByAtleta(@RequestParam(name = "id") Long atletaId) {
        return ResponseEntity.ok(prenotazioneFissaService.getPrenotazioniFisse(atletaId));
    }

    @PostMapping("/addPrenotazioneFissa")
    public ResponseEntity<PrenotazioneFissaDto> addPrenotazioneFissa(@RequestBody PrenotazioneFissaDto prenotazioneFissaDto) {
        return ResponseEntity.ok(prenotazioneFissaService.addPrenotazioneFissa(prenotazioneFissaDto));
    }

    @DeleteMapping("/eliminaPrenotazioneFissa")
    public void eliminaPrenotazioneFissa(@RequestParam(name = "id") Long id) {
        prenotazioneFissaService.deletePrenotazioneFissa(id);
    }

    @PutMapping("/aggiungiPrenotazioneDisdetta")
    public ResponseEntity<PrenotazioneFissaDto> aggiungiPrenotazioneDisdetta(@RequestParam(name = "id") Long id, @RequestBody LocalDate giorno) {
        return ResponseEntity.ok(prenotazioneFissaService.aggiungiPrenotazioneDisdetta(id, giorno));
    }

}
