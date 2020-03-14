/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clasa de Visitor specifica echipelor
 * @author Emilian
 */
public class TeamVisitor implements Visitor {

    /**
     * Metoda de vizitare a unei echipe de fotbal
     * @param team Echipa de fotbal
     * @return Scorul echipei
     */
    @Override
    public double visit(FootballTeam team) {
        // contextul executa operatia pentru echipa de fotbal
        Context context = new Context(new CalculateFootball());
        return context.executeStrategy(team);
    }
    
    /**
     * Metoda de vizitare a unei echipe de baschet
     * @param team Echipa de baschet
     * @return Scorul echipei
     */
    @Override
    public double visit(BasketballTeam team) {
        // contextul executa operatia pentru echipa de baschet
        Context context = new Context(new CalculateBasketball());
        return context.executeStrategy(team);
    }
    
    /**
     * Metoda de vizitare a unei echipe de handbal
     * @param team Echipa de handbal
     * @return Scorul echipei
     */
    @Override
    public double visit(HandballTeam team) {
        // contextul executa operatia pentru echipa de handbal
        Context context = new Context(new CalculateHandball());
        return context.executeStrategy(team);
    }
}
