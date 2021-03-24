package quiz;

import lombok.SneakyThrows;

import java.util.ArrayList;

public class Delivery extends Thread {
    int valueOfDelivery;
    int totalValue;
    ArrayList<Package> packageList;



    public Delivery(ArrayList<Package> packageList) {
        this.packageList = packageList;

    }



    @Override
    @SneakyThrows
    public void run() {


        System.out.println(packageList.get(0));
        Thread.sleep(1000 * packageList.get(0).getDistance());
        for (Package pachet : packageList) {
            valueOfDelivery+= pachet.getDistance();
            totalValue += pachet.getValue();
        }

        System.out.println("The group package value is: " + totalValue);
        System.out.println("The group revenue is " + valueOfDelivery);
        System.out.println();
        System.out.println("______________________________________________________________________________");
        System.out.println();




    }
}
