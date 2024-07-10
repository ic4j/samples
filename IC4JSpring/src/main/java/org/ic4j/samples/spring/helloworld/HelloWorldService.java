package org.ic4j.samples.spring.helloworld;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
@Configuration
@PropertySource("classpath:application.properties")
public class HelloWorldService extends org.ic4j.spring.Service implements HelloWorldProxy {

    

    public HelloWorldService(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @PostConstruct
	public void init() throws URISyntaxException, IOException {
		super.init( HelloWorldProxy.class,null, null, null, null);
	}

    @Override
    @Async
    public CompletableFuture<String> greet(String name) {
        return this.call("greet", name);
    }

}
