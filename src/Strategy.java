/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interfata Strategy pentru calculul scorului unei echipe
 * @author Emilian
 */
public interface Strategy {

    /**
     * Metoda de calculare a scorului echipei
     * @param team Echipa 
     * @return Scorul echipei
     */
    public double doOperation(Team team);
}
