package week8.homework.biathlon;

public class Player {
    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private int recordedTime;
    private int missedShoots;

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getRecordedTime() {
        return recordedTime;
    }

    public void setRecordedTime(int recordedTime) {
        this.recordedTime = recordedTime;
    }

    public int getMissedShoots() {
        return missedShoots;
    }

    public void setMissedShoots(int missedShoots) {
        this.missedShoots = missedShoots;
    }

    @Override
    public String toString() {
        return this.athleteNumber + " " +this.athleteName + " " + this.getRecordedTime();
    }
}
