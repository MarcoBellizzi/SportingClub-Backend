package marco.sporting.controller;

import marco.sporting.data.dto.DebitoDto;
import marco.sporting.data.service.DebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sporting")
@CrossOrigin(origins = "http://localhost:4200")
public class DebitoController {

    @Autowired
    private DebitoService debitoService;

    @PostMapping("/debito/add")
    public ResponseEntity<DebitoDto> save(@RequestBody DebitoDto debitoDto) {
        return ResponseEntity.ok(debitoService.save(debitoDto));
    }

    @GetMapping("/debiti")
    public ResponseEntity<List<DebitoDto>> getAllDebiti() {
        return ResponseEntity.ok(debitoService.getDebiti());
    }

    @GetMapping("/debiti/atleta")
    public ResponseEntity<List<DebitoDto>> getDebiti(@RequestParam(name = "atletaId") Long atletaId) {
        return ResponseEntity.ok(debitoService.getDebiti(atletaId));
    }

    @DeleteMapping("/debito/salda")
    public void saldaDebito(@RequestParam(name = "debitoId") Long debitoId) {
        debitoService.saldaDebito(debitoId);
    }

}
