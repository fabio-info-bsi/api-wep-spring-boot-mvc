package br.com.fabex.api.web;

import br.com.fabex.api.web.listener.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new ApplicationStartedListenerImpl());
        app.addListeners(new ContextRefreshedListenerImpl());
        app.addListeners(new ContextClosedListenerImpl());
        app.addListeners(new ContextStartedListenerImpl());
        app.addListeners(new ContextStoppedListenerImpl());
        app.run(args);
    }

    @EventListener
    public void onShutdown(ContextClosedEvent event) {
        log.info("Event: {}", event);
        log.info("Shutting down...");
    }
}
