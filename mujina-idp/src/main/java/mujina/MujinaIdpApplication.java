package mujina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication()
@Configuration
public class MujinaIdpApplication {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        String[] allowedMethods =
          new String[] {
            HttpMethod.OPTIONS.name(),
            HttpMethod.GET.name(),
            HttpMethod.PUT.name(),
            HttpMethod.POST.name()
          };

        registry
          .addMapping("/**")
          .allowedMethods(allowedMethods)
          .allowedOrigins("*")
          .allowedHeaders("*");
      }
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(MujinaIdpApplication.class, args);
  }

}
