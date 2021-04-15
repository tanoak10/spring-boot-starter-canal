package io.github.tanoak10.starter.canal.config;


import io.github.tanoak10.starter.canal.client.CanalClient;
import io.github.tanoak10.starter.canal.client.SimpleCanalClient;
import io.github.tanoak10.starter.canal.client.transfer.MessageTransponders;
import io.github.tanoak10.starter.canal.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


/**
 * @author chen.qian
 * @date 2018/3/19
 */
public class CanalClientConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(CanalClientConfiguration.class);

    @Autowired
    private CanalConfig canalConfig;

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public BeanUtil beanUtil() {
        return new BeanUtil();
    }

    @Bean
    private CanalClient canalClient() {
        CanalClient canalClient = new SimpleCanalClient(canalConfig, MessageTransponders.defaultMessageTransponder());
        canalClient.start();
        logger.info("Starting canal client....");
        return canalClient;
    }
}