package ch.swisscom.assignment.featuretoggle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import ch.swisscom.assignment.featuretoggle.model.Feature;

public class FeatureMother {
    public static UUID zeroUuid = new UUID(0, 0);
    public static String name = "TestName";
    public static String customerId1 = "1";
    public static String customerId2 = "2";
    public static String customerIdNotIncluded = "false";
    public static List<String> customerIds = List.of(customerId1, customerId2);

    public static Feature getFeature(){
        return Feature.builder()
        .id(zeroUuid)
        .displayName(name)
        .technicalName(name)
        .customerIds(customerIds)
        .expiresOn(LocalDateTime.now())
        .inverted(false)
        .archived(false)
        .build();
    }

}
