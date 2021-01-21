package marco.sporting;

import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.dto.FasciaOrariaDto;
import marco.sporting.data.service.impl.AtletaServiceImpl;
import marco.sporting.data.service.impl.CampoServiceImpl;
import marco.sporting.data.service.impl.FasciaOrariaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SportingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SportingApplication.class, args);

		AtletaServiceImpl atletaService = applicationContext.getBean(AtletaServiceImpl.class);
		CampoServiceImpl campoService = applicationContext.getBean(CampoServiceImpl.class);
		FasciaOrariaServiceImpl fasciaOrariaService = applicationContext.getBean(FasciaOrariaServiceImpl.class);

		AtletaDto marco = new AtletaDto();
		marco.setNome("Marco");
		marco.setCognome("Bellizzi");
		marco.setPassword("password123");
		marco.setEmail("marcobellizzi96@gmail.com");
		marco.setTelefono(3284686896L);
		marco = atletaService.addAtleta(marco);

		AtletaDto andrea = new AtletaDto();
		andrea.setNome("Andrea");
		andrea.setCognome("Meccico");
		andrea.setPassword("password123");
		andrea.setEmail("andreaMeccico@gmail.com");
		andrea.setTelefono(3518024114L);
		andrea = atletaService.addAdmin(andrea);

		AtletaDto niki = new AtletaDto();
		niki.setNome("Niki");
		niki.setCognome("Bellizzi");
		niki.setPassword("password123");
		niki.setEmail("domenico.bellizzi@outlook.com");
		niki.setTelefono(3486851557L);
		niki = atletaService.addAtleta(niki);

		AtletaDto ivan = new AtletaDto();
		ivan.setNome("Ivan");
		ivan.setCognome("Bellizzi");
		ivan.setPassword("password123");
		ivan.setEmail("ivan@gmail.com");
		ivan.setTelefono(3409952509L);
		ivan = atletaService.addAdmin(ivan);

		for(int i=8; i<24; i++) {
			fasciaOrariaService.save(new FasciaOrariaDto("" + i + ":00", "" + i + ":30"));
			fasciaOrariaService.save(new FasciaOrariaDto("" + i + ":30", "" + (i+1) + ":00"));
		}

		CampoDto campoTennisTerraRossa1 = new CampoDto();
		campoTennisTerraRossa1.setNome("Campo da Tennis in terra rossa 1");
		campoTennisTerraRossa1.setDescrizione("Campo da tennis in terra rossa centrale");
		campoTennisTerraRossa1.setPhoto("campoTennis1.jpg");
		campoTennisTerraRossa1 = campoService.addCampo(campoTennisTerraRossa1);

		CampoDto campoTennisTerraRossa2 = new CampoDto();
		campoTennisTerraRossa2.setNome("Campo da Tennis in terra rossa 2");
		campoTennisTerraRossa2.setDescrizione("Campo da tennis in terra rossa laterale");
		campoTennisTerraRossa2.setPhoto("campoTennis2.jpg");
		campoTennisTerraRossa2 = campoService.addCampo(campoTennisTerraRossa2);

		CampoDto campoTennisCoperto = new CampoDto();
		campoTennisCoperto.setNome("Campo da Tennis coperto");
		campoTennisCoperto.setDescrizione("Campo da tennis coperto ideale per le giornate piovose o ventose.");
		campoTennisCoperto.setPhoto("campoTennisCoperto.jpg");
		campoTennisCoperto = campoService.addCampo(campoTennisCoperto);

		CampoDto campoTennisCalcioErbaSintetica = new CampoDto();
		campoTennisCalcioErbaSintetica.setNome("Campo da Tennis e Calcetto");
		campoTennisCalcioErbaSintetica.setDescrizione("Campo da tennis e da calcetto in erba sitetica. Si può usare sia per giocare a tennis che a calcetto");
		campoTennisCalcioErbaSintetica.setPhoto("campoTennisCalcetto.jpg");
		campoTennisCalcioErbaSintetica = campoService.addCampo(campoTennisCalcioErbaSintetica);

		CampoDto campoCalcioGrande = new CampoDto();
		campoCalcioGrande.setNome("Campo da Calcetto");
		campoCalcioGrande.setDescrizione("Campo da Calcetto grande, ideale per giocare 5 contro 5.");
		campoCalcioGrande.setPhoto("campoCalcetto.jpg");
		campoCalcioGrande = campoService.addCampo(campoCalcioGrande);

	}

}
