package br.com.fabex.api.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
public class ContextRefreshedListenerImpl implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        log.info("Handling ContextRefreshedEvent here!");
    }
}