/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interfata care marcheaza ca un obiect poate fi vizitat de un Visitor
 * @author Emilian
 */
public interface Visitable {

    /**
     * Metoda de acceptare a unui visitor
     * @param visitor Visitor-ul
     * @return Rezultatul operatiei de vizitare (scorul echipei)
     */
    public double accept(Visitor visitor);
}
