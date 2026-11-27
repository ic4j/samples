package org.ic4j.samples.spring.helloworld;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.types.Principal;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Configuration
@PropertySource("classpath:application.properties")
public class HelloWorldService implements HelloWorldProxy {

    Environment env;
    Agent agent;
    HelloWorldProxy helloWorldProxy;

    public HelloWorldService(Environment env) {
        this.env = env;
    }

    @PostConstruct
	public void init() throws URISyntaxException {
        String canister = env.getProperty("ic.canister", "zrakb-eaaaa-aaaab-qacaq-cai");
        String location = env.getProperty("ic.location", "https://icp-api.io/");
        boolean fetchRootKey = Boolean.parseBoolean(env.getProperty("ic.fetchRootKey", "false"));
        String host = new URI(location).getHost();
        if (fetchRootKey && !("localhost".equalsIgnoreCase(host) || "127.0.0.1".equals(host)
                || "[::1]".equals(host))) {
            throw new IllegalArgumentException("ic.fetchRootKey requires a loopback ic.location");
        }

        ReplicaTransport transport = ReplicaApacheHttpTransport.create(location);
        agent = new AgentBuilder().transport(transport).build();
        if (fetchRootKey) agent.fetchRootKey();

		helloWorldProxy = ProxyBuilder.create(agent, Principal.fromString(canister)).getProxy(HelloWorldProxy.class);
	}

    @PreDestroy
    public void close() throws Exception {
        agent.close();
    }

    @Override
    @Async
    public CompletableFuture<String> greet(String name) {
        return helloWorldProxy.greet(name);
    }

}
