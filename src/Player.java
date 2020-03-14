/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clasa pentru jucatorul echipei
 * @author Emilian
 */
public class Player implements Comparable<Player> {
    String name;
    int score;
    
    /**
     * Constructorul de setare a numelui si a scorului jucatorului
     * @param name Numele jucatorului
     * @param score Scorul jucatorului
     */
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    @Override
    public String toString() {
        return "{name: " + name + ", score: " + score + "}"; 
    }

    @Override
    public int compareTo(Player o) {
        Player p = (Player)o;
        if(score > p.score)
            return 1;
        else if(score < p.score)
            return -1;
        return 0;
    }
}
