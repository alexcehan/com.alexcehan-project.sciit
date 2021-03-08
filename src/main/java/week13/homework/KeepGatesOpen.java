package week13.homework;

import lombok.SneakyThrows;

public class KeepGatesOpen extends Thread {
    FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread();


    public boolean checkIfSoldOut() {
        if ((festivalStatisticsThread.fullCount + festivalStatisticsThread.fullvipCount + festivalStatisticsThread.freepassCount + festivalStatisticsThread.onedayCount + festivalStatisticsThread.onedayvipCount) > 100) {
            return true;
        } else {
            return false;
        }
    }

    @SneakyThrows
    @Override
    public void run() {

        while (!checkIfSoldOut()) {
            Thread.sleep(200);
            FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread();
            festivalAttendeeThread.start();

            if (checkIfSoldOut()) {
                System.out.println("THE EVENT IS NOW SOLD OUT!!!");
                FestivalStatisticsThread.stopThread = true;
                break;

            }

        }
    }
}
