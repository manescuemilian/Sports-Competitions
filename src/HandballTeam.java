/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clasa pentru echipa de handbal
 * @author Emilian
 */
public class HandballTeam extends Team {

    /**
     * Constructorul de setare a numelui, a genului si a numarului de jucatori
     * @param name Numele echipei
     * @param gender Genul jucatorilor
     * @param number Numarul de jucatori
     */
    public HandballTeam(String name, String gender, int number) {
        super(name, gender, number);
        type = "handball";
    }
    
    /**
     * Metoda de acceptare a unui visitor
     * @param visitor Visitor-ul acceptat
     * @return Rezultatul operatiei de visit (Scorul echipei)
     */
    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
