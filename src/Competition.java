/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clasa pentru competitie
 * @author Emilian
 */
public class Competition {
    String type;
    String gender;
    ArrayList<Team> teams;
    Ranking ranking;
    
    /**
     * Constructorul de setare a tipului si a geului echipelor
     * @param type Tipul echipei (Baschet, Fotbal, Handbal)
     * @param gender Genul jucatorilor echipelor
     */
    public Competition(String type, String gender) {
        this.type = type;
        this.gender = gender;
        teams = new ArrayList<>();
        ranking = new Ranking();
    }
    
    /**
     * Metoda de simulare a jocurilor intre echipe
     * @param visitor Visitor-ul care calculeaza scorul echipei
     */
    public void playMatches(Visitor visitor) {
        double scoreTeam1, scoreTeam2;
        Team team1, team2;
        
        // parcurgerea echipelor din competitie
        // se compara o echipa cu toate echipele de dupe ea in lista,
        // pentru a simula un meci o singura data
        for(int i = 0; i < teams.size(); i++) {
            team1 = teams.get(i);
            for(int j = i + 1; j < teams.size(); j++) {
                team2 = teams.get(j);
                // calcularea scorurilor
                scoreTeam1 = team1.accept(visitor);
                scoreTeam2 = team2.accept(visitor);
                
                // stabilirea punctajelor
                if(scoreTeam1 > scoreTeam2) {
                    team1.points += 3;
                } else if(scoreTeam1 < scoreTeam2) {
                    team2.points += 3;
                } else {
                    team1.points++; team2.points++;
                }

                ranking.updateRanking();
            }
        }
    }
    
    /**
     * Metoda de afisare in fisierul de iesire a clasamentului
     * @param output Fisierul de iesire in care se afiseaza
     */
    public void printRanking(PrintWriter output) {
        // afisarea primelor trei echipe din clasament
        for(int i = 0; i < 3; i++) {
            Team goodTeam = (Team)(ranking.teams.get(i));
            output.println(goodTeam.teamName);
        }
        
        // afisarea locului fiecarei echipe
        for(Team t: teams) {
            output.println("Echipa " + t.teamName + " a ocupat locul "
                    + t.ranked);
        }
    }
}
