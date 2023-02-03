package UAccademy.sfgdi.service;

import org.springframework.stereotype.Service;
@Service
public class AnotherInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - From Another Bean";
    }
}
