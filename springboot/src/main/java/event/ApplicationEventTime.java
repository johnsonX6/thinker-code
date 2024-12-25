package event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author hqz
 * @create 2023/9/16 10:49
 */
@Slf4j
public class ApplicationEventTime implements SpringApplicationRunListener {
    @Override
    public void starting() {
        log.info("starting:{}", LocalDateTime.now());
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {
        log.info("environmentPrepared:{}", LocalDateTime.now());
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {
        log.info("contextPrepared:{}", LocalDateTime.now());
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {
        log.info("contextLoaded:{}", LocalDateTime.now());
    }

    @Override
    public void finished(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {
        log.info("finished:{}", LocalDateTime.now());
    }
}
