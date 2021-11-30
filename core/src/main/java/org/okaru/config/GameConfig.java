package org.okaru.config;

import org.okaru.GuessCount;
import org.okaru.MaxNumber;
import org.okaru.MinNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    //fields
    private int maxNumber = 50;

    private int guessCount = 20;

    private int minNumber = 5;
    //Beans
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
