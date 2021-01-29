package week8.homework.biathlon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class DisplayTop3 {

    public static void main(String[] args) {
        TreeSet<Player> top3Set = new TreeSet<Player>(new PlayerComparator());
        String filename = "src/main/java/week8/homework/biathlon/race_results.csv";
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                if (split[0].equals("Athlete Number")) {
                    continue;
                }
                Player player = new Player();
                player.setAthleteNumber(Integer.parseInt(split[0]));
                player.setAthleteName(split[1]);
                player.setCountryCode(split[2]);
                player.setRecordedTime((Integer.parseInt(split[3].substring(0,2)) * 60) + Integer.parseInt(split[3].substring(3)));
                player.setMissedShoots(countMissedShoots(split[4], split[5], split[6]));


                setTopThree(top3Set, player);


            }

        } catch (IOException e) {
            System.out.println(e);
        }

        printWinners(top3Set);


    }

    public static int countMissedShoots(String... varargs) {
        int missedShoots = 0;

        for(String variable : varargs) {
            for (char c : variable.toCharArray()) {
                if (c == 'o') {
                    missedShoots++;
                }

            }
        }



        return missedShoots;
    }

    public static void setTopThree (TreeSet<Player> treeSet, Player player) {
        int count = 0;
        treeSet.add(player);


        for (Player player1 : treeSet) {
            count++;
            if (count == 4) {
                treeSet.remove(player1);
                count--;
            }

        }

    }

    public static void printWinners (TreeSet<Player> treeSet) {
        int iterate = 1;
        for (Player player : treeSet) {
            int time = player.getRecordedTime() + (player.getMissedShoots() * 10);
            if (iterate == 1) {
                System.out.println("Winner - "+ player.getAthleteName() + " " + ((time/60)+ ":"+(time%60)) + "(" + (player.getRecordedTime()/60 +":"+ player.getRecordedTime()%60) + " + " + (player.getMissedShoots() * 10) + ")");
                iterate++;
            } else if ( iterate == 2) {
                System.out.println("Runner-up - "+ player.getAthleteName() + " " + ((time/60)+ ":"+(time%60)) + "(" + (player.getRecordedTime()/60 +":"+ player.getRecordedTime()%60) + " + " + (player.getMissedShoots() * 10) + ")");
                iterate++;

            } else {
                System.out.println("Third place - "+ player.getAthleteName() + " " + ((time/60)+ ":"+(time%60)) + "(" + (player.getRecordedTime()/60 +":"+ player.getRecordedTime()%60) + " + " + (player.getMissedShoots() * 10) + ")");

            }

        }
    }
}
