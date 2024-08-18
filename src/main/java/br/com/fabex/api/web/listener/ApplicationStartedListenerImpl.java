package br.com.fabex.api.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class ApplicationStartedListenerImpl implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(final ApplicationStartedEvent event) {
        log.info("Handling ApplicationStartedEvent here!");
    }
}