package week13.homework;

public class FestivalApp {

    public static void main(String[] args) {
      Thread keepGatesOpen = new KeepGatesOpen();
      Thread stats = new FestivalStatisticsThread();

        stats.start();
        keepGatesOpen.start();







    }


}
