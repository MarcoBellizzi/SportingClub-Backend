package marco.sporting;

import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.dto.PrenotazioneDto;
import marco.sporting.data.entity.Atleta;
import marco.sporting.data.entity.Campo;
import marco.sporting.data.entity.Prenotazione;
import marco.sporting.data.service.impl.AtletaServiceImpl;
import marco.sporting.data.service.impl.CampoServiceImpl;
import marco.sporting.data.service.impl.PrenotazioneServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SportingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SportingApplication.class, args);

		AtletaServiceImpl atletaService = applicationContext.getBean(AtletaServiceImpl.class);
		CampoServiceImpl campoService = applicationContext.getBean(CampoServiceImpl.class);
		PrenotazioneServiceImpl prenotazioneService = applicationContext.getBean(PrenotazioneServiceImpl.class);

		AtletaDto marco = new AtletaDto();
		marco.setNome("marco");
		marco.setCognome("bellizzi");
		marco = atletaService.addAtleta(marco);

		AtletaDto niki = new AtletaDto();
		niki.setNome("niki");
		niki.setCognome("bellizzi");
		niki = atletaService.addAtleta(niki);

		CampoDto campo = new CampoDto();
		campo.setNome("campo da Calcio grande");
		campo = campoService.addCampo(campo);

		CampoDto campo2 = new CampoDto();
		campo2.setNome("campo da Calcio piccolo");
		campo2 = campoService.addCampo(campo2);

		PrenotazioneDto prenotazione1 = new PrenotazioneDto();
		prenotazione1.setAtleta(marco);
		prenotazione1.setCampo(campo);

		PrenotazioneDto prenotazione2 = new PrenotazioneDto();
		prenotazione2.setAtleta(niki);
		prenotazione2.setCampo(campo2);

		prenotazioneService.addPrenotazione(prenotazione1);
		prenotazioneService.addPrenotazione(prenotazione2);

	}

}
