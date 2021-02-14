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
		marco.setLivello("principiante");
		marco = atletaService.addAtleta(marco);

		AtletaDto niki = new AtletaDto();
		niki.setNome("Niki");
		niki.setCognome("Bellizzi");
		niki.setPassword("password123");
		niki.setEmail("domenico.bellizzi@outlook.com");
		niki.setTelefono(3486851557L);
		niki.setLivello("principiante");
		niki = atletaService.addAtleta(niki);

		AtletaDto ivan = new AtletaDto();
		ivan.setNome("Ivan");
		ivan.setCognome("Bellizzi");
		ivan.setPassword("password123");
		ivan.setEmail("ivan@gmail.com");
		ivan.setTelefono(3409952509L);
		ivan.setLivello("principiante");
		ivan = atletaService.addAtleta(ivan);

		AtletaDto andrea = new AtletaDto();
		andrea.setNome("Andrea");
		andrea.setCognome("Meccico");
		andrea.setPassword("password123");
		andrea.setEmail("andreaMeccico@gmail.com");
		andrea.setTelefono(3518024114L);
		andrea.setLivello("avanzato");
		andrea = atletaService.addAdmin(andrea);

		AtletaDto vittorio = new AtletaDto();
		vittorio.setNome("Vittorio");
		vittorio.setCognome("Meccico");
		vittorio.setPassword("password123");
		vittorio.setEmail("vittorioMeccico@gmail.com");
		vittorio.setTelefono(3896524116L);
		vittorio.setLivello("avanzato");
		vittorio = atletaService.addAdmin(vittorio);

		for(int i=8; i<24; i++) {
			fasciaOrariaService.save(new FasciaOrariaDto("" + i + ":00", "" + i + ":30"));
			fasciaOrariaService.save(new FasciaOrariaDto("" + i + ":30", "" + (i+1) + ":00"));
		}

		CampoDto campoTennisTerraRossa1 = new CampoDto();
		campoTennisTerraRossa1.setNome("Campo da Tennis in terra rossa 1");
		campoTennisTerraRossa1 = campoService.addCampo(campoTennisTerraRossa1);

		CampoDto campoTennisTerraRossa2 = new CampoDto();
		campoTennisTerraRossa2.setNome("Campo da Tennis in terra rossa 2");
		campoTennisTerraRossa2 = campoService.addCampo(campoTennisTerraRossa2);

		CampoDto campoTennisCoperto = new CampoDto();
		campoTennisCoperto.setNome("Campo da Tennis coperto");
		campoTennisCoperto = campoService.addCampo(campoTennisCoperto);

		CampoDto campoTennisCalcioErbaSintetica = new CampoDto();
		campoTennisCalcioErbaSintetica.setNome("Campo da Tennis e Calcetto");
		campoTennisCalcioErbaSintetica = campoService.addCampo(campoTennisCalcioErbaSintetica);

		CampoDto campoCalcioGrande = new CampoDto();
		campoCalcioGrande.setNome("Campo da Calcetto");
		campoCalcioGrande = campoService.addCampo(campoCalcioGrande);

	}

}
