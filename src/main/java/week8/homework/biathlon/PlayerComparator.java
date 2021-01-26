package week8.homework.biathlon;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    public int compare(Player o1, Player o2) {
        if ((o1.getRecordedTime() + (o1.getMissedShoots() * 10)) < (o2.getRecordedTime() + (o2.getMissedShoots() * 10))) {
            return -1;
        } else if ((o1.getRecordedTime() + (o1.getMissedShoots() * 10)) > (o2.getRecordedTime() + (o2.getMissedShoots() * 10))) {
            return 1;
        }

        return 0;
    }
}
