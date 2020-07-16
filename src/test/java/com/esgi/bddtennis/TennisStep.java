package com.esgi.bddtennis;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class TennisStep {

        private Tennis tennis;
        private String score;
        private Player playerOne;
        private Player playerTwo;


    @Given("^(.*) play a match against (.*)$")
        public void scoreToStart(String namePlayerOne, String namePlayerTwo) {

            playerOne=new Player(namePlayerOne);
            playerTwo=new Player(namePlayerTwo);
            tennis = new Tennis(playerOne,playerTwo);
        }
    @And("^(.*) starts the game$")
    public void playToPlayerOne(String playerOne) {
        tennis.startGame();
    }

    @When("^(.*) wins the point$")
    public void pointForSecondPlayer(String playerName) {
        if(playerOne.name.equals(playerName)){
            tennis.pointForPlayer(playerOne);
        }else if (playerTwo.name.equals(playerName)){
            tennis.pointForPlayer(playerTwo);
        }
        score=tennis.scoring();
    }

    @When("^The game starts$")
    public void playGame() {
        tennis.startGame();
        score=tennis.scoring();
    }

    @Then("^The score should be \"(.*)\"$")
    public void theScoreShouldBe(String score){
        Assertions.assertThat(score).isEqualTo(this.score);
    }

    /*@And("^The score is \"(.*)-(.*)\"$")
    public void theScoreIs(String scorePlayerOne, String scorePlayerTwo) {
        //playerOneScores[playerOne.point]=
        this.score=scorePlayerOne+"-"+scorePlayerTwo;
        playerOne.point=tennis.playerOneScores.indexOf(scorePlayerOne);
        playerTwo.point=tennis.playerTwoScores.indexOf(scorePlayerTwo);
    }*/

    @Then("^(.*) should win the match$")
    public void playerShouldWinTheMatch(String playerName) {
        boolean res;
        if(playerOne.name.equals(playerName)){
            res=tennis.hasWin(playerOne);
        }else{
            res=tennis.hasWin(playerTwo);
        }
        Assertions.assertThat(res).isTrue();
    }

    @And("^(.*) should have (.*) game points$")
    public void samShouldHaveGamePoints(String playerName,String points) {
        int res;
        if(playerOne.name.equals(playerName)){
            res=tennis.getGamePoints(playerOne);
        }else{
            res=tennis.getGamePoints(playerTwo);
        }
        Assertions.assertThat(res).isEqualTo(Integer.parseInt(points));

    }


    @And("^The score is \"([^\"]*)\"$")
    public void theScoreIs(String score) {
        if(score.equals("deuce")){
            this.score=score;
            playerOne.point=3;
            playerTwo.point=3;

        }if(score.contains("AD")){
            String[] getPlayer= score.split(" ");
            if(playerOne.name.equals(getPlayer[1])){
                playerOne.point=4;
                playerTwo.point=3;
            }else{
                playerOne.point=3;
                playerTwo.point=4;
            }
        }
        else {
            if (score.contains("-")){
                String[] scorePlayer= score.split("-");
                if(score.contains("all")){
                    playerTwo.point=tennis.playerOneScores.indexOf(scorePlayer[0]);
                    playerOne.point=tennis.playerOneScores.indexOf(scorePlayer[0]);
                }else{
                    playerOne.point=tennis.playerOneScores.indexOf(scorePlayer[0]);
                    playerTwo.point=tennis.playerTwoScores.indexOf(scorePlayer[1]);
                }

            }
        }
    }
}
