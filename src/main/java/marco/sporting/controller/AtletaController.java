package marco.sporting.controller;


import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sporting")
@CrossOrigin(origins = "*")
public class AtletaController {

    @Autowired
    AtletaService atletaService;

    @GetMapping("/login")
    public ResponseEntity<AtletaDto> logIn(@RequestParam(name = "telefono") Long telefono,
                                           @RequestParam(name = "password") String password) {
        System.out.println(telefono + " " + password);
        return ResponseEntity.ok(atletaService.logIn(telefono, password));
    }

    @PostMapping("/atleta/save")
    public ResponseEntity<AtletaDto> save(@RequestBody AtletaDto atletaDto) {
        return ResponseEntity.ok(atletaService.addAtleta(atletaDto));
    }

    @GetMapping("/atleta")
    public ResponseEntity<AtletaDto> getAtleta(@RequestParam(name = "nome") String nome,
                                               @RequestParam(name = "cognome") String cognome) {
        return ResponseEntity.ok(atletaService.getAtleta(nome, cognome));
    }

    @GetMapping("/atleti")
    public ResponseEntity<List<AtletaDto>> getAtleti() {
        return ResponseEntity.ok(atletaService.getAtleti());
    }

    @GetMapping("/atleti/admin")
    public ResponseEntity<List<AtletaDto>> getAdmins() {
        return ResponseEntity.ok(atletaService.getAdmin());
    }

    @GetMapping("/atleti/notAdmin")
    public ResponseEntity<List<AtletaDto>> getNotAdmins() {
        return ResponseEntity.ok(atletaService.getNotAdmin());
    }

    @PutMapping("/atleta/update")
    public ResponseEntity<AtletaDto> update(@RequestBody AtletaDto atletaDto) {
        return ResponseEntity.ok(atletaService.update(atletaDto));
    }


}
