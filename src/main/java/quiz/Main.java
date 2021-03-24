package quiz;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Am folosit Java 8 Stream in clasa Package pentru citit continutul CSV-ului
 * Am folosit si Thread pentru printarea rezultatului, declarat in clasa Delivery.
 * Am creat clasa Package si am vazut ulterior ca poate fi o chestie confuza in java dar am mers cu numele asta pana la capat.
 * Am creat si un comparator pentru sortare desi lista era sortata deja dar am zis... "hai sa pretindem ca nu e".
 * Ai sa observezi ca absolut toate listele sunt declarate peste tot ca ArrayList ceea ce mi se pare cam urat dar m-am chinuit
 * foarte mult sa scap de 'unchecked warnings', ulterior am descoperit @SuppressWarning dar nu am mai refacut toate listele
 * ca inainte. Per total codul nu ma incanta cum arata chiar daca outputul indeplineste cerintele problemei.
 * Probabil daca as fi stapanit mai bine Java 8 as fi putut sa il fac sa arate mai placut pentru ochi si poate mai
 * eficent dar asa recunosc ca m-a chinuit un pic
 *
 * **/


@SuppressWarnings("unchecked")
public class Main {


    public static void main(String[] args) throws IOException{

        ArrayList<ArrayList<Package>> list = returnTheBigList(Package.returnListOfPackages());

        for (ArrayList<Package> list1 : list) {
            Thread delivery = new Delivery(list1);
            delivery.run();

        }

    }




    public static ArrayList<ArrayList<Package>> returnTheBigList(ArrayList<Package> list) {
        ArrayList<ArrayList<Package>> listToReturn = new ArrayList<ArrayList<Package>>();
        ArrayList<Package> list1 = new ArrayList<>();
        for(Package pachet : list) {
            if ((list1.size() == 0 || (pachet.equals(list1.get(0))))) {
                list1.add(pachet);
            } else {
                listToReturn.add(new ArrayList<>(list1));
                list1.clear();
                list1.add(pachet);
            }
        }

        return listToReturn;
    }






}
