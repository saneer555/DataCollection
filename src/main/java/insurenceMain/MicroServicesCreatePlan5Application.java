package insurenceMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Data Collection", version="1.0",description="Saneer" ))
public class MicroServicesCreatePlan5Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesCreatePlan5Application.class, args);
	}

}
