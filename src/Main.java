/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.ArrayList;

/**
 * Clasa main, in care se folosesc fisierele de intrare si iesire, 
 * se afiseaza echipele adaugate si se simuleaza meciurile din competitie
 * @author Emilian
 */
public class Main {
    
    /**
     * Metoda de cautare a unei echipe
     * @param teams Lista de echipe in care se cauta
     * @param name Numele echipei cautate
     * @param comp Competitia in care se cauta echipa respectiva
     * @return Echipa gasita (daca este cazul), sau null, in cazul in care 
     * echipa nu exista sau genul si tipul echipei nu corespund competitiei
     */
    public static Team findTeam(ArrayList<Team> teams, String name, 
            Competition comp) {
        Team team = null;
        // parcurgem toate echipele
        for(Team t: teams) {
            if(t.teamName.equals(name)) {
                // verificam daca echipa respectiva poate participa
                if(t.gender.equals(comp.gender) && 
                        t.type.equals(comp.type)) {
                    
                    team = t;
                    // in caz pozitiv, iesim din for
                    break;
                }
            }
        }
        return team;
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException Exceptia aruncata in cazul in care nu exista
     * fisierele
     */
    public static void main(String[] args) throws IOException {
        String linie;
        String[] info;
        Team team;
        Player player;
        int number, score;
        ArrayList<Team> teams = new ArrayList<>();
        PrintWriter output = new PrintWriter(args[3]); // fisierul de iesire
        FileReader fr1, fr2;
        fr1 = new FileReader(args[1]);
        
        // parcurgerea primului fisier de intrare
        try (BufferedReader in1 = new BufferedReader(fr1)) {
            // instantierea factory-ului (care este singleton)
            TeamFactory factory = TeamFactory.getInstance();
            
            while(( linie = in1.readLine() ) != null) {
                info = linie.split(", "); // separam termenii de pe linie
                number = Integer.parseInt(info[3]);
                // cream echipa si o adaugam in lista
                team = factory.createTeam(info[0], info[1], info[2], number);
                teams.add(team);
                
                // adaugam fiecare jucator in echipa
                for(int i = 0; i < number; i++) {
                    linie = in1.readLine();
                    info = linie.split(", ");
                    score = Integer.parseInt(info[1]);
                    player = new Player(info[0], score);
                    team.players.add(player);
                }
            }
            in1.close(); // inchiderea primului fisier de intrare
            // afisarea echipelor adaugate
            if(args[0].equals("inscriere")) {
                for(Team t: teams) {
                    output.println(t);
                }
                
            } else if(args[0].equals("competitie")) {
                fr2 = new FileReader(args[2]);
                String type, gender;
                // deschiderea celui de-al doilea fisier de intrare
                try (BufferedReader in2 = new BufferedReader(fr2)) {
                    linie = in2.readLine();
                    info = linie.split(", ");
                    type = info[0]; gender = info[1];
                    
                    // instantierea competitiei si a visitor-ului
                    Competition competition = new Competition(type, gender);
                    Visitor visitor = new TeamVisitor();
                    
                    // parcurgerea fisierului de intrare si cautarea echipei
                    while(( linie = in2.readLine() ) != null) {
                        Team t = findTeam(teams, linie, competition);
                        // daca s-a gasit echipa, se adauga in competitie
                        if(t != null) {
                            competition.teams.add(t);
                            competition.ranking.addObserver(t);
                        }   
                    }
                    in2.close(); // inchiderea celui de-al doilea fisier
                    // simularea meciurilor si afisarea clasamentului
                    competition.playMatches(visitor);
                    competition.printRanking(output);

                } catch (FileNotFoundException e) {
                    System.out.println("Input file 2 doesn't exist.");
                }
            }
      
        } catch(FileNotFoundException e) {
            System.out.println("Input file 1 doesn't exist.");
        } finally {
            output.close();
        }
    }
}
