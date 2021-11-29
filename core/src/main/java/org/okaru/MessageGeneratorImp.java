package org.okaru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImp implements MessageGenerator{

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImp.class);

    @Autowired
    private Game game;

//    private int guessCount = 10;

    @PostConstruct
    void logMessage(){
        log.debug("Numero generado es {}", game.getGuessCount());
    }
    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                "Can you guess it ?";
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()){
            return "You gessed it! The number was " + game.getNumber();
        }else if(game.isGameLost()){
            return "You Lost! the number was " + game.getNumber();
        }else if(!game.isValidNumberRange()) {
            return "Invalid number of range!";
        }else if(game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        }else{
            String direction = "Lower";
            if(game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + "guess left";
        }
    }
}
