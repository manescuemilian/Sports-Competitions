/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interfata pentru un visitor
 * @author Emilian
 */
public interface Visitor {

    /**
     * Metoda de visitare a unei echipe de fotbal, pentru calculul scorului
     * @param team Echipa de fotbal
     * @return Scorul echipei
     */
    public double visit(FootballTeam team);

    /**
     * Metoda de visitare a unei echipe de baschet, pentru calculul scorului
     * @param team Echipa de baschet
     * @return Scorul echipei
     */
    public double visit(BasketballTeam team);

    /**
     * Metoda de visitare a unei echipe de handbal, pentru calculul scorului
     * @param team Echipa de handbal
     * @return Scorul echipei
     */
    public double visit(HandballTeam team);
}
