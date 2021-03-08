package week13.homework;

public class FestivalGate {

    private  int fullCount = 0;
    private int fullvipCount = 0;
    private int freepassCount = 0;
    private int onedayCount = 0;
    private int onedayvipCount = 0;

    String name;
    int gateNumber;

    public FestivalGate(String name, int gateNumber) {
        this.name = name;
        this.gateNumber = gateNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
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
}
