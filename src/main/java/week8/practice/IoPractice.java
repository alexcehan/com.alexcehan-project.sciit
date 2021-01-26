package week8.practice;
import java.net.URL;
import java.io.IOException;
import java.util.Scanner;

public class IoPractice {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.biathlonworld.com/competitions/world-cup/events/bmw-ibu-world-cup-biathlon-antholz-anterselva-2021/bt2021swrlcp07/race/men-20km-individual/bt2021swrlcp07smin/");

        Scanner scanner = new Scanner(url.openStream());

        StringBuffer stringBuffer = new StringBuffer();

        while (scanner.hasNext()) {
            stringBuffer.append(scanner.next());
            //System.out.println(scanner.next());
        }


        String result = stringBuffer.toString();
        System.out.println(result);

        result = result.replaceAll("<[^>]*>", "");

        System.out.println(result);
    }
}
