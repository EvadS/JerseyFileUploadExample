package de.bytefish.fileuploads;

import de.bytefish.fileuploads.provider.IRootPathProvider;
import de.bytefish.fileuploads.provider.RootPathProvider;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SampleJerseyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SampleJerseyApplication()
				.configure(new SpringApplicationBuilder(SampleJerseyApplication.class))
				.run(args);
	}

	@Bean
	IRootPathProvider rootPathProvider() {
        return new RootPathProvider("./out");
    }
}