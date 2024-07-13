package org.ic4j.samples.spring.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @PostMapping("greet")
    public String greet(@RequestBody String name) {
        return helloWorldService.greet(name).join();
    }
    
    
}
