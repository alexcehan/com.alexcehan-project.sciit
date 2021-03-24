package quiz;

import java.util.Comparator;

public class PackageComparator implements Comparator<Package> {

    @Override
    public int compare(Package o1, Package o2) {

        if(o1.getTargetLocation().equals(o2.getTargetLocation())) {
            return (o1.getDeliveryDate().compareTo(o2.getDeliveryDate()));
        } else {
            return (o1.getTargetLocation().compareTo(o2.getTargetLocation()));
        }

    }
}