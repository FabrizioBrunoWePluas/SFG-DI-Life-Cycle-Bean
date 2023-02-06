package UAccademy.sfgdi.controllers;

import UAccademy.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnotherInjectedController {


    @Autowired
    public GreetingService greetingService;

    public String getGreeting()
    {
        return greetingService.sayGreeting();
    }
}
