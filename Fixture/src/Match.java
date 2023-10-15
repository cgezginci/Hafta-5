
import java.util.ArrayList;
import java.util.Collections;

public class Match {

    private static ArrayList<String> team = new ArrayList<>();


    static {
        team.add("Fenerbahçe");
        team.add("Galatasaray");
        team.add("Bursaspor");
        team.add("Beşiktaş");
        team.add("Başakşehir");
        team.add("Trabzonspor");
        team.add("Ankaragücü");
    }

    public static void run(){

        if (team.size() % 2 != 0){
            team.add("Bay");
        }
        int teamNumber = team.size();
        int Rounds = teamNumber - 1;

        for (int MatchNumber = 1; MatchNumber < Rounds; MatchNumber++ ){
            System.out.println("Round: " + MatchNumber );
            ArrayList<String> randomTeams = new ArrayList<>(team);
            Collections.shuffle(randomTeams);
            for (int i = 0; i < teamNumber / 2; i++ ){
                String home = randomTeams.get(i);
                String guess = randomTeams.get(teamNumber - 1 - i);

                if (home.equals("Bay") || guess.equals("Bay")) {
                    System.out.println(home + " vs " + guess  );
                }else {
                    System.out.println(home + " vs " + guess);
                }
            }
            System.out.println("*******************");
        }


    }

}
