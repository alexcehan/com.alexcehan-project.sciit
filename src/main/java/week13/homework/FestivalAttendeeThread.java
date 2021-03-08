package week13.homework;

public class FestivalAttendeeThread extends Thread {

    private FestivalAttendee festivalAttendee;

    @Override
    public void run() {
        festivalAttendee = new FestivalAttendee();

        switch (festivalAttendee.gateNumber) {
            case 1:
                switch (festivalAttendee.getTicketType()) {
                    case "full":
                        FestivalStatisticsThread.northGate.setFullCount(FestivalStatisticsThread.northGate.getFullCount() + 1);
                        break;
                    case "full-vip":
                        FestivalStatisticsThread.northGate.setFullvipCount(FestivalStatisticsThread.northGate.getFullvipCount() + 1);
                        break;
                    case "free-pass":
                        FestivalStatisticsThread.northGate.setFreepassCount(FestivalStatisticsThread.northGate.getFreepassCount() + 1);
                        break;
                    case "one-day":
                        FestivalStatisticsThread.northGate.setOnedayCount(FestivalStatisticsThread.northGate.getOnedayCount() + 1);
                        break;
                    case "one-day-vip":
                        FestivalStatisticsThread.northGate.setOnedayvipCount(FestivalStatisticsThread.northGate.getOnedayvipCount() + 1);
                        break;
                    default:
                        break;
                }
            case 2:
                switch (festivalAttendee.getTicketType()) {
                    case "full":
                        FestivalStatisticsThread.centralGate.setFullCount(FestivalStatisticsThread.centralGate.getFullCount() + 1);
                        break;
                    case "full-vip":
                        FestivalStatisticsThread.centralGate.setFullvipCount(FestivalStatisticsThread.centralGate.getFullvipCount() + 1);
                        break;
                    case "free-pass":
                        FestivalStatisticsThread.centralGate.setFreepassCount(FestivalStatisticsThread.centralGate.getFreepassCount() + 1);
                        break;
                    case "one-day":
                        FestivalStatisticsThread.centralGate.setOnedayCount(FestivalStatisticsThread.centralGate.getOnedayCount() + 1);
                        break;
                    case "one-day-vip":
                        FestivalStatisticsThread.centralGate.setOnedayvipCount(FestivalStatisticsThread.centralGate.getOnedayvipCount() + 1);
                        break;
                    default:
                        break;
                }
            case 3:
                switch (festivalAttendee.getTicketType()) {
                    case "full":
                        FestivalStatisticsThread.southGate.setFullCount(FestivalStatisticsThread.southGate.getFullCount() + 1);
                        break;
                    case "full-vip":
                        FestivalStatisticsThread.southGate.setFullvipCount(FestivalStatisticsThread.southGate.getFullvipCount() + 1);
                        break;
                    case "free-pass":
                        FestivalStatisticsThread.southGate.setFreepassCount(FestivalStatisticsThread.southGate.getFreepassCount() + 1);
                        break;
                    case "one-day":
                        FestivalStatisticsThread.southGate.setOnedayCount(FestivalStatisticsThread.southGate.getOnedayCount() + 1);
                        break;
                    case "one-day-vip":
                        FestivalStatisticsThread.southGate.setOnedayvipCount(FestivalStatisticsThread.southGate.getOnedayvipCount() + 1);
                        break;
                    default:
                        break;
                }
        }
    }
}
