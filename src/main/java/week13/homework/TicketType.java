package week13.homework;

import java.util.Random;

public enum TicketType {
    FULL("full"),
    FULLVIP("full-vip"),
    FREEPASS("free-pass"),
    ONEDAY("one-day"),
    ONEDAYVIP("one-day-vip");

    private final String ticketType;

    private TicketType(String ticketType) {
        this.ticketType = ticketType;
    }



    @Override
    public String toString() {
        switch (this) {
            case FULL: return "full";
            case FULLVIP: return "full-vip";
            case FREEPASS: return "free-pass";
            case ONEDAY: return "one-day";
            case ONEDAYVIP: return "one-day-vip";
            default: return null;
        }
    }

    public static TicketType getRandomTicket() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
