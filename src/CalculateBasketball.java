/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clasa care calculeaza scorul pentru o echipa de baschet
 * @author Emilian
 */
public class CalculateBasketball implements Strategy {
    
    /**
     * Metoda de calcul a scorului unei echipe de baschet
     * @param team Echipa de baschet
     * @return Scorul echipei de baschet
     */
    @Override
    public double doOperation(Team team) {
        double score = 0;
        int number = 0;
        // parcurgem toti jucatorii echipei
        for(Player p: team.players) {
            score += p.score;
            number++;
        }
        
        // calcularea mediei
        score = score / number;
        return score;
    }
}
