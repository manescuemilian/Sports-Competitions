/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * Interfata pentru observator
 * @author Emilian
 */
public interface Observer extends Comparable<Observer> {

    /**
     * Metoda de actualizare a observatorului
     * @param o Lista sortata de observatori, in care cautam observatorul curent
     */
    public void update(ArrayList<Observer> o);
}
