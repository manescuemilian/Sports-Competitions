/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 * Clasa pentru clasamentul echipelor
 * @author Emilian
 */
public class Ranking {

    /**
     * Lista de observatori
     */
    public ArrayList<Observer> teams;
    
    /**
     * Constructorul implicit, in care se intitializeaza lista de echipe
     */
    public Ranking() {
        teams = new ArrayList<>();
    }
    
    /**
     * Metoda de adaugare a unui observator
     * @param o Observatorul adaugat
     */
    public void addObserver(Observer o) {
        teams.add(o);
    }
    
    /**
     * Metoda de stergere a unui observator
     * @param o Observatorul sters
     */
    public void removeObserver(Observer o) {
        teams.remove(o);
    }
    
    /**
     * Metoda de actualizare a clasamentului, dupa disputarea unui meci
     */
    public void updateRanking() {
        // sortam echipele dupa punctaj, apoi notificam observatorii
        Collections.sort(teams);
        for(Observer o: teams) {
            ((Team)o).update(teams);
        }
    }
    
}
