package br.com.fabex.api.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

@Slf4j
public class ContextStartedListenerImpl implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(final ContextStartedEvent event) {
        log.info("Handling ContextStartedEvent here!");
    }
}