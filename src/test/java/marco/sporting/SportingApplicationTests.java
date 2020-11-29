package marco.sporting;

import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.dto.PrenotazioneDto;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.Prenotazione;
import marco.sporting.data.service.impl.AtletaServiceImpl;
import marco.sporting.data.service.impl.CampoServiceImpl;
import marco.sporting.data.service.impl.PrenotazioneServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SportingApplicationTests {

	@Autowired
	private AtletaServiceImpl atletaService;

	@Autowired
	private CampoServiceImpl campoService;

	@Autowired
	private PrenotazioneServiceImpl prenotazioneService;

	@Test
	public void test() throws Exception {
		AtletaDto atleta = new AtletaDto();
		atleta.setNome("marco");
		atleta.setCognome("bellizzi");
		AtletaDto saved = atletaService.addAtleta(atleta);

		AtletaDto atleta2 = new AtletaDto();
		atleta2.setNome("niki");
		atleta2.setCognome("bellizzi");
		AtletaDto saved2 = atletaService.addAtleta(atleta2);

		CampoDto campo = new CampoDto();
		campo.setNome("campo da Calcio grande");
		CampoDto savedc = campoService.addCampo(campo);

		CampoDto campo2 = new CampoDto();
		campo2.setNome("campo da Calcio piccolo");
		CampoDto savedc2 = campoService.addCampo(campo2);

		prenotazioneService.addPrenotazione(saved, savedc);

		for(AtletaDto a : atletaService.getAtleti()) {
			System.out.println(a);
		}
		for(CampoDto c : campoService.getCampi()) {
			System.out.println(c);
		}
		for(PrenotazioneDto p : prenotazioneService.getPrenotazioni()) {
			System.out.println(p);
		}
	}

}
