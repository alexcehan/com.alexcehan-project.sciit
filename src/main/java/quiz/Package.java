package quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
public class Package {
    private String targetLocation;
    private int distance;
    private int value;
    private Date deliveryDate;

    public Package() {

    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }


    public void setDeliveryDate(Date date) {
        this.deliveryDate = date;
    }

    @Override
    public boolean equals(Object obj) {
        Package aPackage = (Package) obj;
        if ((this.targetLocation.equals(aPackage.targetLocation)) && (this.deliveryDate.equals(aPackage.deliveryDate))) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return ("[Delivering for <"+targetLocation +"> and date " + dateFormat.format(deliveryDate) + " in <" + distance + "> seconds]" );
    }

    public static ArrayList returnListOfPackages() throws IOException {


        File file = new File ("src/main/java/quiz/file.csv");

        List<Package> packageList = Files.readAllLines(file.toPath())
                .stream()
                .filter(s -> StringUtils.isNotBlank(s))
                .map(Package::mapLineToPackage)
                .collect(Collectors.toList());

        Collections.sort(packageList, new PackageComparator());


        return (ArrayList) packageList;
    }

    @SneakyThrows
    private static Package mapLineToPackage(String line) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String[] fields = line.split(",");
        return Package.builder()
                .targetLocation(fields[0])
                .distance(Integer.parseInt(fields[1]))
                .value(Integer.parseInt(fields[2]))
                .deliveryDate(df.parse(fields[3]))
                .build();
    }
}
