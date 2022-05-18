package ma.atos.agency;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class AgencyApplication {

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {

		SpringApplication.run(AgencyApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
