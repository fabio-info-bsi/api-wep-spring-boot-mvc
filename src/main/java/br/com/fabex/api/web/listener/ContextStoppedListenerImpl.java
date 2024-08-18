package br.com.fabex.api.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

@Slf4j
public class ContextStoppedListenerImpl implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(final ContextStoppedEvent event) {
        log.info("Handling ContextStoppedEvent here!");
    }
}