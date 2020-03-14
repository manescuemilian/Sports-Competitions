/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Contextul in care se efectueaza operatiile de calcul a scorului
 * @author Emilian
 */
public class Context {
    private Strategy strategy;

    /**
     * Constructorul de creare a contextului, cu o anumita strategie
     * @param strategy Strategia folosita
     */
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * Metoda de executare a operatiei
     * @param team Echipa pe care se executa operatia
     * @return Scorul echipei
     */
    public double executeStrategy(Team team){
        // contextul executa operatia necesara
        return strategy.doOperation(team);
    }
}
