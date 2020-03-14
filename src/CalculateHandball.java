/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clasa care calculeaza scorul pentru o echipa de handbal
 * @author Emilian
 */
public class CalculateHandball implements Strategy {

    /**
     * Metoda de calcul a scorului unei echipe de handbal
     * @param team Echipa de handbal
     * @return Scorul echipei de handbal
     */
    @Override
    public double doOperation(Team team) {
        int score;
         
        if(team.gender.equals("masculin")) {
            score = 0;
            // calcularea ca suma, pentru genul masculin
            for(Player p: team.players) {
                score += p.score;
            }
        } else {
            score = 1;
            // calcularea ca produs, pentru genul feminin
            for(Player p: team.players) {
                score *= p.score;
            }
            
        }
        return score;
    }
    
}
