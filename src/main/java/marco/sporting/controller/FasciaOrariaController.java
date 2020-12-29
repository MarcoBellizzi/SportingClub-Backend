package marco.sporting.controller;

import marco.sporting.data.dto.FasciaOrariaDto;
import marco.sporting.data.service.FasciaOrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sporting")
public class FasciaOrariaController {

    @Autowired
    private FasciaOrariaService fasciaOrariaService;

    @GetMapping("/fasceOrarie")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<FasciaOrariaDto>> getFasceOrarie() {
        return ResponseEntity.ok(fasciaOrariaService.getFasceOrarie());
    }

}
