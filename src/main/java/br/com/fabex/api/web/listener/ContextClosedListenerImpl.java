package br.com.fabex.api.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@Slf4j
public class ContextClosedListenerImpl implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(final ContextClosedEvent event) {
        log.info("Handling ContextClosedEvent here!");
    }
}