package org.okaru.config;

import org.okaru.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "org.okaru")
public class AppConfig {

    //beans
    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImp();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImp();
    }

}
