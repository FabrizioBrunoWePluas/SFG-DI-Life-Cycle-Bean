package UAccademy.sfgdi.config;

import UAccademy.sfgdi.repositories.EnglishGreetingRepository;
import UAccademy.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import UAccademy.sfgdi.services.*;
import com.springframewoke.pet.PetService;
import com.springframewoke.pet.PetServiceFActory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFActory petServiceFActory(){
        return new PetServiceFActory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFActory petServiceFActory){
        return petServiceFActory.petService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFActory petServiceFActory){
        return petServiceFActory.petService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

}