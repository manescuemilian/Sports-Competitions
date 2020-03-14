/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collections;

/**
 * Clasa de calcul a scorului unei echipe de fotbal
 * @author Emilian
 */
public class CalculateFootball implements Strategy {
    
    /**
     * Metoda de calcul a scorului unei echipe de fotbal
     * @param team Echipa de fotbal
     * @return Scorul echipei de fotbal
     */
    @Override
    public double doOperation(Team team) {
        int score = 0;
        
        // mai intai adaugam toate scorurile
        for(Player p: team.players) {
            score += p.score;
        }
        
        // apoi adaugam cel mai mic sau cel mai mare scor, in functie de gen
        if(team.gender.equals("masculin")) {
            score += Collections.max(team.players).score;
        } else {
            score += Collections.min(team.players).score;
        }
        
        return score;
    }
}
