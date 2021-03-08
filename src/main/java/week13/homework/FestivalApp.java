package week13.homework;

public class FestivalApp {

    public static void main(String[] args) {
      Thread keepGates = new KeepGatesOpen();
      Thread stats = new FestivalStatisticsThread();

        stats.start();
        keepGates.start();







    }


}
