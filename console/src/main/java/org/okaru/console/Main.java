package org.okaru.console;

import org.okaru.config.AppConfig;
import org.okaru.Game;
import org.okaru.MessageGenerator;
import org.okaru.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess the number");

        //create a context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        //get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        //call method next() to get a randon number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}", number);

        //get game bean from context (container)
        Game game = context.getBean(Game.class);

        //call reset method
        //game.reset();

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        String nani = messageGenerator.getMainMessage();

        log.info("primer mensaje {}", nani);

        String nani2 = messageGenerator.getResultMessage();

        log.info("Segundo mensaje es {}", nani2);

        //close context
        context.close();
    }

}
