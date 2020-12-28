package marco.sporting.controller;


import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
