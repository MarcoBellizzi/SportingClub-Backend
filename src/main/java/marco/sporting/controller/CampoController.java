package marco.sporting.controller;

import marco.sporting.data.dao.CampoDao;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.service.CampoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sporting")
public class CampoController {

    @Autowired
    private CampoService campoService;

    @GetMapping("/campi")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<CampoDto>> getCampi() {
        return ResponseEntity.ok(campoService.getCampi());
    }

}
