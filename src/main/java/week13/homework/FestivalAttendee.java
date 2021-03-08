package week13.homework;

import java.util.Random;

public class FestivalAttendee extends Thread{
    int gateNumber;
    String ticketType;

    public FestivalAttendee() {
        this.ticketType = randomTicket();
        this.gateNumber = randomGateNumber();

    }

    public int getGateNumber() {
        return gateNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public static int randomGateNumber() {
        int gateNumber = 0;
        Random random = new Random();

        while (true) {
            gateNumber = random.nextInt(4);
            if(gateNumber !=0) {
                break;
            }
        }

        return gateNumber;
    }

    public static String randomTicket() {
        return (TicketType.getRandomTicket().toString());
    }




}
