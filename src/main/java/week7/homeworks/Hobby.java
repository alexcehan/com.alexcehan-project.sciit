package week7.homeworks;

import java.util.ArrayList;

public class Hobby {
    private String name;
    private int frequency;
    private ArrayList<String> addresses = new ArrayList<>();



    public Hobby() {

    }

    public Hobby(String name, int frequency, String ...address) {
        this.name = name;
        this.frequency = frequency;

        for (String item: address) {
            this.addresses.add(item);
        }

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

//    public List<String> getAddressesList() {
//        return addressesList;
//    }
//
//    public void setAddressesList(List<String> addressesList) {
//        this.addressesList = addressesList;
//    }


    @Override
    public String toString() {
        String address = "";
        for (int i = 0; i < addresses.size(); i++) {
            address+=addresses.get(i);
            if (i == addresses.size() - 1) {
                address+= ".";
            } else {
                address+=", ";
            }

        }
        return ("Hobby: " + name + ". Can be practiced in:  " + address);
    }
}


