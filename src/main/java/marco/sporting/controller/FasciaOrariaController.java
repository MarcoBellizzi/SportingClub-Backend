package marco.sporting.controller;

import marco.sporting.data.dto.FasciaOrariaDto;
import marco.sporting.data.service.FasciaOrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sporting")
@CrossOrigin(origins = "*")
public class FasciaOrariaController {

    @Autowired
    private FasciaOrariaService fasciaOrariaService;

    @GetMapping("/fasceOrarie")
    public ResponseEntity<List<FasciaOrariaDto>> getFasceOrarie() {
        return ResponseEntity.ok(fasciaOrariaService.getFasceOrarie());
    }

    @GetMapping("/fasciaOraria")
    public ResponseEntity<FasciaOrariaDto> getFasciaOraria(@RequestParam(name = "fasciaId") Long fasciaId) {
        return ResponseEntity.ok(fasciaOrariaService.getFasciaOraria(fasciaId));
    }

}
