package com.mutant;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Bean
    public DataSource getDataSource() {
		String urlEntorno = System.getenv().get("CLEARDB_DATABASE_URL");
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
		if(urlEntorno==null) {
			System.out.println("ATENCION : Variable de entorno CLEARDB_DATABASE_URL no encontrada");
			dataSourceBuilder.url("jdbc:mysql://localhost:3306/mutant?serverTimezone=America/Santiago&useSSL=false&allowPublicKeyRetrieval=true");
			dataSourceBuilder.username("root");
			dataSourceBuilder.password("root");
		} else {
			System.out.println("Variable de entorno CLEARDB_DATABASE_URL encontrada.");
			dataSourceBuilder.url("jdbc:"+urlEntorno);
		}
        return dataSourceBuilder.build();
    }
}
