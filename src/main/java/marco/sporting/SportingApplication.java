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
		marco.setUsername("marcoBellizzi");
		marco.setPassword("password123");
		marco.setEmail("marcobellizzi96@gmail.com");
		marco.setTelefono(3284686896L);
		marco = atletaService.addAtleta(marco);

		AtletaDto andrea = new AtletaDto();
		andrea.setNome("Andrea");
		andrea.setCognome("Meccico");
		andrea.setUsername("andreaMeccico");
		andrea.setPassword("password123");
		andrea.setEmail("nonloso@gmail.com");
		andrea.setTelefono(3518024114L);
		andrea = atletaService.addAdmin(andrea);

		for(int i=8; i<24; i++) {
			fasciaOrariaService.save(new FasciaOrariaDto(i, i+1));
		}

		CampoDto campoCalcioGrande = new CampoDto();
		campoCalcioGrande.setNome("Campo da Calcio grande");
		campoCalcioGrande = campoService.addCampo(campoCalcioGrande);

		CampoDto campoTennisTerraRossa1 = new CampoDto();
		campoTennisTerraRossa1.setNome("Campo da Tennis in terra rossa 1");
		campoTennisTerraRossa1 = campoService.addCampo(campoTennisTerraRossa1);

		CampoDto campoTennisTerraRossa2 = new CampoDto();
		campoTennisTerraRossa2.setNome("Campo da Tennis in terra rossa 2");
		campoTennisTerraRossa2 = campoService.addCampo(campoTennisTerraRossa2);

		CampoDto campoTennisCalcioErbaSintetica = new CampoDto();
		campoTennisCalcioErbaSintetica.setNome("Campo da Tennis e Calcetto");
		campoTennisCalcioErbaSintetica = campoService.addCampo(campoTennisCalcioErbaSintetica);

		CampoDto campoTennisCoperto = new CampoDto();
		campoTennisCoperto.setNome("Campo da Tennis coperto");
		campoTennisCoperto = campoService.addCampo(campoTennisCoperto);

	}

}
