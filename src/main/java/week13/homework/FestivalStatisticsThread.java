package week13.homework;

import lombok.SneakyThrows;

public class FestivalStatisticsThread extends Thread {

    public static FestivalGate northGate = new FestivalGate("northGate", 1);
    public static FestivalGate centralGate = new FestivalGate("centralGate", 2);
    public static FestivalGate southGate = new FestivalGate("southGate", 3);

    static int fullCount;
    static int fullvipCount;
    static int freepassCount;
    static int onedayCount ;
    static int onedayvipCount ;
    public static boolean stopThread;

    public FestivalStatisticsThread() {

    }

    public FestivalGate getNorthGate() {
        return northGate;
    }

    public void setNorthGate(FestivalGate northGate) {
        this.northGate = northGate;
    }

    public FestivalGate getCentralgate() {
        return centralGate;
    }

    public void setCentralgate(FestivalGate centralgate) {
        this.centralGate = centralgate;
    }

    public FestivalGate getSouthGate() {
        return southGate;
    }

    public void setSouthGate(FestivalGate southGate) {
        this.southGate = southGate;
    }

    public int getFullCount() {
        return fullCount;
    }

    public void setFullCount(int fullCount) {
        this.fullCount = fullCount;
    }

    public int getFullvipCount() {
        return fullvipCount;
    }

    public void setFullvipCount(int fullvipCount) {
        this.fullvipCount = fullvipCount;
    }

    public int getFreepassCount() {
        return freepassCount;
    }

    public void setFreepassCount(int freepassCount) {
        this.freepassCount = freepassCount;
    }

    public int getOnedayCount() {
        return onedayCount;
    }

    public void setOnedayCount(int onedayCount) {
        this.onedayCount = onedayCount;
    }

    public int getOnedayvipCount() {
        return onedayvipCount;
    }

    public void setOnedayvipCount(int onedayvipCount) {
        this.onedayvipCount = onedayvipCount;
    }

    public static void printValues() {
         fullCount = (northGate.getFullCount() + centralGate.getFullCount() + southGate.getFullCount());
         fullvipCount = (northGate.getFullvipCount() + centralGate.getFullvipCount() + southGate.getFullvipCount());
        freepassCount = (northGate.getFreepassCount() + centralGate.getFreepassCount() + southGate.getFreepassCount());
        onedayCount = (northGate.getOnedayCount() + centralGate.getOnedayCount()+ southGate.getOnedayCount());
        onedayvipCount = (northGate.getOnedayvipCount() + centralGate.getOnedayvipCount() + southGate.getOnedayvipCount());
        
        
        
        

        System.out.println("====================================================================================================================");

        System.out.println("Stats from North Gate: ");
        System.out.println((northGate.getFullCount() + northGate.getFullvipCount() + northGate.getFreepassCount() + northGate.getOnedayCount() + northGate.getOnedayvipCount()) + " people have entered");
        System.out.println((northGate.getFullCount()) + " people have full tickets!");
        System.out.println((northGate.getFullvipCount()) + " people have full VIP passes!");
        System.out.println((northGate.getFreepassCount()) + " have free passes!");
        System.out.println((northGate.getOnedayCount()) + " have one-day passes");
        System.out.println((northGate.getOnedayvipCount()) + " have one-day VIP passes");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        System.out.println("Stats from Central Gate: ");
        System.out.println((centralGate.getFullCount() + centralGate.getFullvipCount() + centralGate.getFreepassCount() + centralGate.getOnedayCount() + centralGate.getOnedayvipCount()) + " people have entered");
        System.out.println((centralGate.getFullCount()) + " people have full tickets!");
        System.out.println((centralGate.getFullvipCount()) + " people have full VIP passes!");
        System.out.println((centralGate.getFreepassCount()) + " have free passes!");
        System.out.println((centralGate.getOnedayCount()) + " have one-day passes");
        System.out.println((centralGate.getOnedayvipCount()) + " have one-day VIP passes");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        System.out.println("Stats from South Gate: ");
        System.out.println((southGate.getFullCount() + southGate.getFullvipCount() + southGate.getFreepassCount() + southGate.getOnedayCount() + southGate.getOnedayvipCount()) + " people have entered");
        System.out.println((southGate.getFullCount()) + " people have full tickets!");
        System.out.println((southGate.getFullvipCount()) + " people have full VIP passes!");
        System.out.println((southGate.getFreepassCount()) + " have free passes!");
        System.out.println((southGate.getOnedayCount()) + " have one-day passes");
        System.out.println((southGate.getOnedayvipCount()) + " have one-day VIP passes");
        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        
        System.out.println("Stats from all gates: ");
        System.out.println((fullCount + fullvipCount + onedayCount + onedayvipCount + freepassCount) + " people have entered");
        System.out.println((northGate.getFullCount() + centralGate.getFullCount() + southGate.getFullCount()) + " people have full tickets!");
        System.out.println(fullvipCount + " people have full VIP passes!");
        System.out.println( freepassCount + " have free passes!");
        System.out.println(onedayCount + " have one-day passes");
        System.out.println(onedayvipCount + " have one-day VIP passes");
        System.out.println("====================================================================================================================");
        System.out.println("\n\n");

    }



    @SneakyThrows
    @Override
    public void run() {



        while (!stopThread) {
            Thread.sleep(2000);
            printValues();



        }








    }


}
