/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clasa Factory, care se ocupa de crearea echipelor
 * @author Emilian
 */
public class TeamFactory {
    private static TeamFactory uniqueInstance;
    private TeamFactory() {}

    /**
     * Metoda Singleton de creare a unei singure instante
     * @return Instanta unica a clasei
     */
    public static TeamFactory getInstance() {
        // daca instanta nu a fost creata, se creaza, altfel se returneaza
        if(uniqueInstance == null) {
            uniqueInstance = new TeamFactory();
        }
        return uniqueInstance;
    }
    
    /**
     * Metoda de creare a unei echipe
     * @param type Tipul echipei (Baschet, Fotbal, Handbal)
     * @param name Numele echipei
     * @param gender Genul jucatorilor echipei
     * @param number Numarul de jucatori ai echipei
     * @return Instanta creata
     */
    public Team createTeam(String type, String name, String gender, int number) {
        Team team = null;
        // se verifica tipul echipei create
        if(type.equals("football")) {
            team = new FootballTeam(name, gender, number);
        } else if(type.equals("basketball")) {
            team = new BasketballTeam(name, gender, number);
        } else if(type.equals("handball")) {
            team = new HandballTeam(name, gender, number);
        }
        return team;
    }
}
