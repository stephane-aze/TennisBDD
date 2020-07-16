package com.esgi.bddtennis;

import java.util.ArrayList;
import java.util.Arrays;

public class Tennis {

    private Player playerOne;
    private Player playerTwo;
    ArrayList<String> playerOneScores = new ArrayList<>(Arrays.asList("love", "fifteen", "thirty", "forty", "", ""));
    ArrayList<String> playerTwoScores = new ArrayList<>(Arrays.asList("love","fifteen","thirty","forty","",""));


    Tennis(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
    public static void main(String[] args) {

    }
    void startGame(){
        playerOne.point=0;
        playerTwo.point=0;
    }
    String scoring(){
        if (hasAdvantage()) {
            return "AD " + playerWithHighestScore();
        }
        if (isDeuce()){
            return "deuce";
        }
        if(playerOne.point==playerTwo.point){
            return playerOneScores.get(playerOne.point)+"-all";
        }
        return playerOneScores.get(playerOne.point)+"-"+playerTwoScores.get(playerTwo.point);
    }

    private String playerWithHighestScore() {
        if(playerOne.point>playerTwo.point){
            return playerOne.name;
        }
        return playerTwo.name;
    }

    private boolean hasAdvantage() {
        if (playerOne.point >= 4 && playerOne.point == playerTwo.point + 1){
            return true;

        }

        return playerTwo.point >= 4 && playerTwo.point==playerOne.point+1;

    }

    private boolean isDeuce() {
        return playerOne.point==playerTwo.point && playerTwo.point>=3;
    }

    private Boolean hasGamePoints(Player p){

        if(!gameFinish()){
            if(p.equals(playerOne)){
                return playerOne.point-playerTwo.point>=1&& playerOne.point>=3 ;
            }else{
                return p.point-playerOne.point>=1&& playerTwo.point>=3;
            }
        }
        return false;
    }
    Integer getGamePoints(Player p){
        if(hasGamePoints(p)){
            int ecart = Math.abs(playerOne.point-playerTwo.point);
            return ecart;
        }
        return null;
    }
    Boolean hasWin(Player p){
        if(playerOne.equals(p)){
            return p.point-playerTwo.point>=2&& p.point>=4;
        }else{
            return p.point-playerOne.point>=2&& p.point>=4;
        }
    }
    private boolean gameFinish() {
        return Math.abs(playerOne.point-playerTwo.point)>=2&&(playerOne.point>=4 || playerTwo.point>=4);
    }

    void pointForPlayer(Player player){
        player.point++;
    }
}
