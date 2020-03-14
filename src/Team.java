/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * Clasa abstracta, reprezentand o echipa
 * @author Emilian
 */
public abstract class Team implements Visitable, Observer {
    String teamName;
    String gender;
    int numberOfPlayers;
    ArrayList<Player> players;
    String type;
    int points;
    int ranked;
    
    /**
     * Constructor de setare a numelui, genului si a numarului de jucatori
     * @param name Numele echipei
     * @param gender Genul jucatorilor
     * @param number Numarul de jucatori din echipa
     */
    public Team(String name, String gender, int number) {
        teamName = name;
        this.gender = gender;
        numberOfPlayers = number;
        players = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "{teamName: " + teamName + ", gender: " + gender + 
                ", numberOfPlayers: " + numberOfPlayers + ", players: " +
                players + "}";
    }

    /**
     * Metoda abstracta, de acceptare a unui visitor
     * @param visitor Visitor-ul acceptat
     * @return Rezultatul operatiei de vizitare (scorul echipei)
     */
    @Override
    public abstract double accept(Visitor visitor);

    /**
     * Metoda de actualizare a locului unei echipe in clasament
     * @param teams ArrayList-ul de observatori
     */
    @Override
    public void update(ArrayList<Observer> teams) {
        // parcurgem observatorii sortati si setam locul in clasament pentru
        // observatorul curent
        for(Observer t: teams) {
            if(((Team)t).teamName.equals(teamName)) {
                ranked = teams.indexOf(t) + 1;
            }
        }
    }
    
    @Override
    public int compareTo(Observer o) {
        Team t = (Team)o;
        if(points > t.points) 
            return -1;
        else if(points < t.points)
            return 1;
        return 0;
    }

}
