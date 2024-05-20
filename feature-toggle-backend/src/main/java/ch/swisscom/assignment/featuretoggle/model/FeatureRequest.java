package ch.swisscom.assignment.featuretoggle.model;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FeatureRequest {
    private String customerId;
    private List<UUID> featureIds;
}
