package marco.sporting;

import marco.sporting.data.dto.AtletaDto;
import marco.sporting.data.dto.CampoDto;
import marco.sporting.data.dto.FasciaOrariaDto;
import marco.sporting.data.service.impl.AtletaServiceImpl;
import marco.sporting.data.service.impl.CampoServiceImpl;
import marco.sporting.data.service.impl.FasciaOrariaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SportingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SportingApplication.class, args);

	//	inizializzaDB(applicationContext);

	}

	public static void inizializzaDB(ApplicationContext applicationContext) {
		AtletaServiceImpl atletaService = applicationContext.getBean(AtletaServiceImpl.class);
		CampoServiceImpl campoService = applicationContext.getBean(CampoServiceImpl.class);
		FasciaOrariaServiceImpl fasciaOrariaService = applicationContext.getBean(FasciaOrariaServiceImpl.class);

		AtletaDto marco = new AtletaDto();
		marco.setNome("Marco");
		marco.setCognome("Bellizzi");
		marco.setPassword("password123");
		marco.setTelefono(3284686896L);
		marco = atletaService.addAdmin(marco);

		AtletaDto andrea = new AtletaDto();
		andrea.setNome("Andrea");
		andrea.setCognome("Meccico");
		andrea.setPassword("password123");
		andrea.setTelefono(3518024114L);
		andrea = atletaService.addAdmin(andrea);

		for(int i=8; i<24; i++) {
			fasciaOrariaService.save(new FasciaOrariaDto("" + i + ":00", "" + i + ":30"));
			fasciaOrariaService.save(new FasciaOrariaDto("" + i + ":30", "" + (i+1) + ":00"));
		}

		CampoDto campoTennisTerraRossa1 = new CampoDto();
		campoTennisTerraRossa1.setNome("Tennis Terra 1");
		campoTennisTerraRossa1 = campoService.addCampo(campoTennisTerraRossa1);

		CampoDto campoTennisTerraRossa2 = new CampoDto();
		campoTennisTerraRossa2.setNome("Tennis Terra 2");
		campoTennisTerraRossa2 = campoService.addCampo(campoTennisTerraRossa2);

		CampoDto campoTennisCoperto = new CampoDto();
		campoTennisCoperto.setNome("Tennis Coperto");
		campoTennisCoperto = campoService.addCampo(campoTennisCoperto);

		CampoDto campoTennisCalcioErbaSintetica = new CampoDto();
		campoTennisCalcioErbaSintetica.setNome("Tennis e Calcetto");
		campoTennisCalcioErbaSintetica = campoService.addCampo(campoTennisCalcioErbaSintetica);

		CampoDto campoCalcioGrande = new CampoDto();
		campoCalcioGrande.setNome("Calcetto");
		campoCalcioGrande = campoService.addCampo(campoCalcioGrande);
	}

}
