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
public class AtletaController {

    @Autowired
    AtletaService atletaService;

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AtletaDto> logIn(@RequestParam(name = "username") String username,
                                           @RequestParam(name = "password") String password) {
        return ResponseEntity.ok(atletaService.logIn(username, password));
    }

    @PostMapping("/atleta/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AtletaDto> save(@RequestBody AtletaDto atletaDto) {
        return ResponseEntity.ok(atletaService.addAtleta(atletaDto));
    }

    @GetMapping("/atleta")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AtletaDto> getAtleta(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(atletaService.getAtleta(username));
    }

    @GetMapping("/atleti")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<AtletaDto>> getAtleti() {
        return ResponseEntity.ok(atletaService.getAtleti());
    }



}
